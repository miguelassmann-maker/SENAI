// Aqui ficam os dados que o sistema vai usar.
// Os dados são salvos no localStorage para não sumirem quando atualizar a página.
let clientes = [];
let auditorias = [];
let relatorioAtual = "geral";


// Aqui carrega os dados salvos no navegador.
function carregarDados() {

    const clientesSalvos = localStorage.getItem("crmClientes");
    const auditoriasSalvas = localStorage.getItem("crmAuditorias");

    if (clientesSalvos) {
        clientes = JSON.parse(clientesSalvos);
    }

    if (auditoriasSalvas) {
        auditorias = JSON.parse(auditoriasSalvas);
    }
}


// Aqui salva os dados no navegador.
function salvarDados() {
    localStorage.setItem("crmClientes", JSON.stringify(clientes));
    localStorage.setItem("crmAuditorias", JSON.stringify(auditorias));
}


// Mostra uma mensagem de sucesso ou erro no canto da tela.
function mostrarMensagem(mensagem, tipo) {

    const caixa = document.getElementById("mensagemFlutuante");
    const alerta = document.getElementById("alertaMensagem");

    alerta.textContent = mensagem;
    alerta.className = "alert shadow mb-0";

    if (tipo === "erro") {
        alerta.classList.add("alert-danger");
    } else {
        alerta.classList.add("alert-success");
    }

    caixa.style.display = "block";

    setTimeout(function () {
        caixa.style.display = "none";
    }, 3500);
}


// Pega a data e hora atual no formato brasileiro.
function pegarDataAtual() {
    const data = new Date();
    return data.toLocaleDateString("pt-BR") + " " + data.toLocaleTimeString("pt-BR", {
        hour: "2-digit",
        minute: "2-digit"
    });
}


function limparCpf(cpf) {
    return cpf.replace(/\D/g, "");
}


function formatarCpf(cpf) {
    const cpfLimpo = limparCpf(cpf).slice(0, 11);
    return cpfLimpo
        .replace(/(\d{3})(\d)/, "$1.$2")
        .replace(/(\d{3})(\d)/, "$1.$2")
        .replace(/(\d{3})(\d{1,2})$/, "$1-$2");
}


function formatarTelefone(telefone) {
    const telefoneLimpo = telefone.replace(/\D/g, "").slice(0, 11);

    if (telefoneLimpo.length <= 10) {
        return telefoneLimpo
            .replace(/(\d{2})(\d)/, "($1) $2")
            .replace(/(\d{4})(\d)/, "$1-$2");
    }

    return telefoneLimpo
        .replace(/(\d{2})(\d)/, "($1) $2")
        .replace(/(\d{5})(\d)/, "$1-$2");
}


function emailValido(email) {
    return /^[^\s@]+@[^\s@]+\.[^\s@]+$/.test(email);
}


function cpfJaExiste(cpf, idCliente) {

    const cpfLimpo = limparCpf(cpf);

    return clientes.some(function (cliente) {
        return limparCpf(cliente.cpf) === cpfLimpo && cliente.id !== idCliente;
    });
}


// Registra tudo que acontece de importante no sistema.
function registrarAuditoria(tipo, nomeCliente, descricao) {

    const novaAuditoria = {
        id: Date.now(),
        data: pegarDataAtual(),
        tipo: tipo,
        cliente: nomeCliente,
        descricao: descricao
    };

    auditorias.unshift(novaAuditoria);
}


// Troca a tela que aparece na página.
function trocarTela(nomeTela) {

    const telas = document.querySelectorAll(".tela");
    const botoesMenu = document.querySelectorAll(".botaoMenu");

    telas.forEach(function (tela) {
        tela.classList.remove("ativa");
    });

    botoesMenu.forEach(function (botao) {
        botao.classList.remove("ativo");

        if (botao.dataset.tela === nomeTela) {
            botao.classList.add("ativo");
        }
    });

    document.getElementById(nomeTela).classList.add("ativa");

    if (nomeTela === "home") {
        atualizarHome();
    }

    if (nomeTela === "consulta") {
        renderizarClientes(clientes);
    }

    if (nomeTela === "relatorios") {
        renderizarRelatorio();
    }

    if (nomeTela === "auditoria") {
        renderizarAuditorias();
    }
}


// Atualiza os números e a lista da home.
function atualizarHome() {

    const ativos = clientes.filter(function (cliente) {
        return cliente.status === "Ativo";
    });

    const inativos = clientes.filter(function (cliente) {
        return cliente.status === "Inativo";
    });

    document.getElementById("totalClientes").textContent = clientes.length;
    document.getElementById("totalAtivos").textContent = ativos.length;
    document.getElementById("totalInativos").textContent = inativos.length;
    document.getElementById("totalAuditorias").textContent = auditorias.length;

    const ultimosClientes = document.getElementById("ultimosClientes");
    ultimosClientes.innerHTML = "";

    if (clientes.length === 0) {
        ultimosClientes.innerHTML = "<p class='text-muted'>Nenhum cliente cadastrado ainda.</p>";
        return;
    }

    // Pega só os 5 primeiros da lista.
    const ultimos = clientes.slice(0, 5);

    ultimos.forEach(function (cliente) {
        const item = document.createElement("div");
        item.className = "border-start border-danger border-3 ps-3 mb-3";
        item.innerHTML =
            "<strong>" + cliente.nome + "</strong><br>" +
            "<small class='text-muted'>CPF: " + cliente.cpf + " | " + cliente.cidade + " - " + cliente.estado + " | " + cliente.dataCadastro + "</small>";
        ultimosClientes.appendChild(item);
    });
}


// Aqui faz o cadastro ou a alteração do cliente.
function cadastrarOuAlterarCliente(event) {

    event.preventDefault();

    const idCliente = document.getElementById("idCliente").value;
    const nome = document.getElementById("nome").value.trim();
    const cpf = formatarCpf(document.getElementById("cpf").value);
    const telefone = formatarTelefone(document.getElementById("telefone").value);
    const email = document.getElementById("email").value.trim();
    const cidade = document.getElementById("cidade").value.trim();
    const estado = document.getElementById("estado").value;
    const status = document.getElementById("status").value;

    // Validações antes de salvar.
    if (nome === "") {
        mostrarMensagem("Digite o nome do cliente.", "erro");
        return;
    }

    if (limparCpf(cpf).length !== 11) {
        mostrarMensagem("Digite um CPF com 11 números.", "erro");
        return;
    }

    if (!emailValido(email)) {
        mostrarMensagem("Digite um e-mail válido.", "erro");
        return;
    }

    if (cpfJaExiste(cpf, Number(idCliente))) {
        mostrarMensagem("Este CPF já está cadastrado.", "erro");
        return;
    }

    if (idCliente === "") {

        // Aqui cria o objeto do novo cliente.
        const novoCliente = {
            id: Date.now(),
            nome: nome,
            cpf: cpf,
            telefone: telefone,
            email: email,
            cidade: cidade,
            estado: estado,
            dataCadastro: pegarDataAtual(),
            status: status
        };

        clientes.unshift(novoCliente);
        registrarAuditoria("Cadastro", nome, "Cliente cadastrado com status " + status + ".");
        mostrarMensagem("Cliente cadastrado com sucesso.");

    } else {

        // Aqui encontra o cliente pelo id e atualiza.
        const indiceCliente = clientes.findIndex(function (cliente) {
            return cliente.id === Number(idCliente);
        });

        const clienteAntigo = clientes[indiceCliente];
        const mudancas = [];

        if (clienteAntigo.nome !== nome) mudancas.push("Nome alterado de " + clienteAntigo.nome + " para " + nome + ".");
        if (clienteAntigo.telefone !== telefone) mudancas.push("Telefone alterado de " + clienteAntigo.telefone + " para " + telefone + ".");
        if (clienteAntigo.email !== email) mudancas.push("E-mail alterado de " + clienteAntigo.email + " para " + email + ".");
        if (clienteAntigo.cidade !== cidade) mudancas.push("Cidade alterada de " + clienteAntigo.cidade + " para " + cidade + ".");
        if (clienteAntigo.estado !== estado) mudancas.push("Estado alterado de " + clienteAntigo.estado + " para " + estado + ".");
        if (clienteAntigo.status !== status) mudancas.push("Status alterado de " + clienteAntigo.status + " para " + status + ".");

        clientes[indiceCliente] = {
            ...clienteAntigo,
            nome: nome,
            telefone: telefone,
            email: email,
            cidade: cidade,
            estado: estado,
            status: status
        };

        if (mudancas.length > 0) {
            registrarAuditoria("Alteração", nome, mudancas.join(" "));
        } else {
            registrarAuditoria("Alteração", nome, "Cliente salvo sem mudança nos dados.");
        }

        mostrarMensagem("Cliente alterado com sucesso.");
    }

    salvarDados();
    cancelarEdicao();
    atualizarHome();
    renderizarClientes(clientes);
}


// Coloca os clientes dentro da tabela.
function renderizarClientes(listaClientes) {

    const corpoTabela = document.getElementById("corpoTabelaClientes");
    corpoTabela.innerHTML = "";

    if (listaClientes.length === 0) {
        corpoTabela.innerHTML = "<tr><td colspan='6' class='text-center text-muted'>Nenhum cliente encontrado.</td></tr>";
        return;
    }

    listaClientes.forEach(function (cliente) {
        const linha = document.createElement("tr");
        linha.innerHTML =
            "<td>" + cliente.nome + "</td>" +
            "<td>" + cliente.cpf + "</td>" +
            "<td>" + (cliente.telefone || "Não informado") + "</td>" +
            "<td>" + cliente.email + "</td>" +
            "<td><span class='status " + cliente.status + "'>" + cliente.status + "</span></td>" +
            "<td>" +
                "<button class='btn btn-sm btn-outline-danger me-1' onclick='editarCliente(" + cliente.id + ")'>Editar</button>" +
                "<button class='btn btn-sm btn-danger' onclick='excluirCliente(" + cliente.id + ")'>Excluir</button>" +
            "</td>";
        corpoTabela.appendChild(linha);
    });
}


// Filtra os clientes conforme o que foi digitado na pesquisa.
function pesquisarClientes() {

    const tipoPesquisa = document.getElementById("tipoPesquisa").value;
    const campoPesquisa = document.getElementById("campoPesquisa").value.trim().toLowerCase();

    if (campoPesquisa === "") {
        renderizarClientes(clientes);
        return;
    }

    const listaFiltrada = clientes.filter(function (cliente) {
        if (tipoPesquisa === "cpf") {
            return limparCpf(cliente.cpf).includes(limparCpf(campoPesquisa));
        }

        return cliente[tipoPesquisa].toLowerCase().includes(campoPesquisa);
    });

    renderizarClientes(listaFiltrada);
}


// Preenche o formulário com os dados do cliente para editar.
function editarCliente(idCliente) {

    const cliente = clientes.find(function (clienteAtual) {
        return clienteAtual.id === idCliente;
    });

    if (!cliente) {
        mostrarMensagem("Cliente não encontrado.", "erro");
        return;
    }

    document.getElementById("idCliente").value = cliente.id;
    document.getElementById("nome").value = cliente.nome;
    document.getElementById("cpf").value = cliente.cpf;
    document.getElementById("telefone").value = cliente.telefone;
    document.getElementById("email").value = cliente.email;
    document.getElementById("cidade").value = cliente.cidade;
    document.getElementById("estado").value = cliente.estado;
    document.getElementById("status").value = cliente.status;
    document.getElementById("dataCadastro").value = cliente.dataCadastro;
    document.getElementById("tituloCadastro").textContent = "Alterar cliente";
    document.getElementById("botaoSalvar").textContent = "Salvar alteração";
    document.getElementById("botaoCancelarEdicao").classList.remove("d-none");

    trocarTela("cadastro");
}


// Limpa o formulário e volta ao estado de novo cadastro.
function cancelarEdicao() {
    document.getElementById("formularioCliente").reset();
    document.getElementById("idCliente").value = "";
    document.getElementById("dataCadastro").value = "Automática";
    document.getElementById("tituloCadastro").textContent = "Cadastro de clientes";
    document.getElementById("botaoSalvar").textContent = "Cadastrar cliente";
    document.getElementById("botaoCancelarEdicao").classList.add("d-none");
}


// Exclui o cliente depois de pedir confirmação.
function excluirCliente(idCliente) {

    const cliente = clientes.find(function (clienteAtual) {
        return clienteAtual.id === idCliente;
    });

    if (!cliente) {
        mostrarMensagem("Cliente não encontrado.", "erro");
        return;
    }

    const confirmarExclusao = confirm("Deseja realmente excluir o cliente " + cliente.nome + "?");

    if (!confirmarExclusao) {
        return;
    }

    clientes = clientes.filter(function (clienteAtual) {
        return clienteAtual.id !== idCliente;
    });

    registrarAuditoria("Exclusão", cliente.nome, "Cliente excluído em " + pegarDataAtual() + ".");
    salvarDados();
    atualizarHome();
    pesquisarClientes();
    mostrarMensagem("Cliente excluído com sucesso.");
}


// Coloca as auditorias dentro da tabela.
function renderizarAuditorias() {

    const corpoTabela = document.getElementById("corpoTabelaAuditoria");
    corpoTabela.innerHTML = "";

    if (auditorias.length === 0) {
        corpoTabela.innerHTML = "<tr><td colspan='4' class='text-center text-muted'>Nenhuma ação registrada ainda.</td></tr>";
        return;
    }

    auditorias.forEach(function (auditoria) {
        const linha = document.createElement("tr");
        linha.innerHTML =
            "<td>" + auditoria.data + "</td>" +
            "<td>" + auditoria.tipo + "</td>" +
            "<td>" + auditoria.cliente + "</td>" +
            "<td>" + auditoria.descricao + "</td>";
        corpoTabela.appendChild(linha);
    });
}


// Monta o conteúdo do relatório conforme a aba escolhida.
function renderizarRelatorio() {

    const conteudoRelatorio = document.getElementById("conteudoRelatorio");
    conteudoRelatorio.innerHTML = "";

    if (relatorioAtual === "data") {

        // Aqui agrupa os clientes por data de cadastro.
        const clientesPorData = {};

        clientes.forEach(function (cliente) {
            const dataSemHora = cliente.dataCadastro.split(" ")[0];

            if (!clientesPorData[dataSemHora]) {
                clientesPorData[dataSemHora] = 0;
            }

            clientesPorData[dataSemHora]++;
        });

        const datas = Object.keys(clientesPorData);

        if (datas.length === 0) {
            conteudoRelatorio.innerHTML = "<p class='text-muted'>Nenhum cliente cadastrado ainda.</p>";
            return;
        }

        datas.forEach(function (data) {
            conteudoRelatorio.innerHTML +=
                "<div class='d-flex justify-content-between border-bottom py-2'>" +
                "<strong>" + data + "</strong>" +
                "<span>" + clientesPorData[data] + " cliente(s)</span>" +
                "</div>";
        });

        return;
    }

    // Define qual lista vai ser mostrada no relatório.
    let listaDoRelatorio = clientes;
    let tituloRelatorio = "Relatório geral — " + clientes.length + " cliente(s)";

    if (relatorioAtual === "ativos") {
        listaDoRelatorio = clientes.filter(function (cliente) {
            return cliente.status === "Ativo";
        });
        tituloRelatorio = "Clientes ativos — " + listaDoRelatorio.length + " cliente(s)";
    }

    if (relatorioAtual === "inativos") {
        listaDoRelatorio = clientes.filter(function (cliente) {
            return cliente.status === "Inativo";
        });
        tituloRelatorio = "Clientes inativos — " + listaDoRelatorio.length + " cliente(s)";
    }

    conteudoRelatorio.innerHTML = "<h5 class='mb-3'>" + tituloRelatorio + "</h5>";

    if (listaDoRelatorio.length === 0) {
        conteudoRelatorio.innerHTML += "<p class='text-muted'>Nenhum cliente para mostrar aqui.</p>";
        return;
    }

    listaDoRelatorio.forEach(function (cliente) {
        conteudoRelatorio.innerHTML +=
            "<div class='d-flex justify-content-between align-items-center border-bottom py-2'>" +
            "<div><strong>" + cliente.nome + "</strong><br><small class='text-muted'>" + cliente.cpf + " | " + cliente.email + "</small></div>" +
            "<span class='status " + cliente.status + "'>" + cliente.status + "</span>" +
            "</div>";
    });
}


// Aqui configura todos os cliques e eventos da página.
function configurarEventos() {

    document.querySelectorAll(".botaoMenu").forEach(function (botao) {
        botao.addEventListener("click", function () {
            trocarTela(botao.dataset.tela);
        });
    });

    document.getElementById("botaoIrCadastro").addEventListener("click", function () {
        trocarTela("cadastro");
    });

    document.getElementById("formularioCliente").addEventListener("submit", cadastrarOuAlterarCliente);
    document.getElementById("botaoCancelarEdicao").addEventListener("click", cancelarEdicao);
    document.getElementById("botaoPesquisar").addEventListener("click", pesquisarClientes);

    document.getElementById("botaoLimparPesquisa").addEventListener("click", function () {
        document.getElementById("campoPesquisa").value = "";
        renderizarClientes(clientes);
    });

    document.getElementById("campoPesquisa").addEventListener("input", pesquisarClientes);

    document.getElementById("cpf").addEventListener("input", function (event) {
        event.target.value = formatarCpf(event.target.value);
    });

    document.getElementById("telefone").addEventListener("input", function (event) {
        event.target.value = formatarTelefone(event.target.value);
    });

    document.querySelectorAll(".botaoAba").forEach(function (botao) {
        botao.addEventListener("click", function () {
            document.querySelectorAll(".botaoAba").forEach(function (botaoAtual) {
                botaoAtual.classList.remove("ativo");
            });

            botao.classList.add("ativo");
            relatorioAtual = botao.dataset.relatorio;
            renderizarRelatorio();
        });
    });

    document.getElementById("botaoLimparAuditoria").addEventListener("click", function () {

        if (auditorias.length === 0) {
            mostrarMensagem("Não existe auditoria para limpar.", "erro");
            return;
        }

        if (confirm("Deseja realmente apagar todos os registros de auditoria?")) {
            auditorias = [];
            salvarDados();
            renderizarAuditorias();
            atualizarHome();
            mostrarMensagem("Auditoria limpa com sucesso.");
        }
    });
}


// Aqui inicia tudo quando a página carrega.
carregarDados();
configurarEventos();
atualizarHome();
renderizarClientes(clientes);
renderizarRelatorio();
renderizarAuditorias();
