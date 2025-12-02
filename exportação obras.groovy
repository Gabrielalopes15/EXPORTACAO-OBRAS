def classificacaoTipoObra (){
  //FONTE
  fonteClassificacoesObras = Dados.obras.v1.classificacoesObras;
  dadosClassificacoesObras = fonteClassificacoesObras.busca(campos: "descricao")
  
  csv = Arquivo.novo('classificacaoTipodeObra.csv','csv',[delimitador: ';' ])
  
  //CABEÇALHO ARQUIVO
  csv.escrever('descricao')
  csv.novaLinha()
  
  percorrer (dadosClassificacoesObras) { itemClassificacoesObras ->
    //DADOS
    csv.escrever(item.descricao)
    csv.novaLinha()
  }
  return csv
}


def motivosDeParalisacao (){
  
  fonteMotivosParalisacao = Dados.obras.v1.motivosParalisacao;
  dadosMotivosParalisacao = fonteMotivosParalisacao.busca(campos: "descricao")
  
  csv = Arquivo.novo('motivosDeParalisacao.csv','csv',[delimitador: ';' ])
  csv.escrever('descricao')
  csv.novaLinha()
  
  percorrer (dadosMotivosParalisacao) { itemMotivosParalisacao ->
    
    csv.escrever(item.descricao)
    csv.novaLinha()
  }
  return csv
}


def tiposDeObra (){
  
  fonteTiposObra = Dados.obras.v1.tiposObra;
  dadosTiposObra = fonteTiposObra.busca(campos: "descricao")
  
  csv = Arquivo.novo('tiposdeobras.csv','csv',[delimitador: ';' ])
  csv.escrever('descricao')
  csv.novaLinha()
  
  percorrer (dadosTiposObra) { itemTiposObra ->
    
    csv.escrever(item.descricao)
    csv.novaLinha()
  }
  return csv
}


def tiposderesponsabilidades (){
  
  fonteTiposResponsabilidadeTecnica = Dados.obras.v1.tiposResponsabilidadeTecnica;
  dadosTiposResponsabilidadeTecnica = fonteTiposResponsabilidadeTecnica.busca(campos: "descricao")
  
  csv = Arquivo.novo('tiposderesponsabilidades.csv','csv',[delimitador: ';' ])
  csv.escrever('descricao')
  csv.novaLinha()
  
  percorrer (dadosTiposResponsabilidadeTecnica) { itemTiposResponsabilidadeTecnica ->
    
    csv.escrever(item.descricao)
    csv.novaLinha()
  }
  return csv
}

def tiposderesponsaveis (){
  
  fonteTiposResponsavel = Dados.obras.v1.tiposResponsavel;
  dadosTiposResponsavel = fonteTiposResponsavel.busca(campos: "descricao")
  
  
  csv = Arquivo.novo('tiposderesponsaveis.csv','csv',[delimitador: ';' ])
  csv.escrever('descricao')
  csv.novaLinha()
  
  percorrer (dadosTiposResponsavel) { itemTiposResponsavel ->
    
    csv.escrever(item.descricao)
    csv.novaLinha()
  }
  return csv
}

def tipodemedicao (){
  
  fonteTiposMedicao = Dados.obras.v1.tiposMedicao;
  dadosTiposMedicao = fonteTiposMedicao.busca(campos: "descricao")
  
  
  csv = Arquivo.novo('tipodemedicao.csv','csv',[delimitador: ';' ])
  csv.escrever('descricao')
  csv.novaLinha()
  
  percorrer (dadosTiposMedicao) { itemTiposMedicao ->
    
    csv.escrever(item.descricao)
    csv.novaLinha()
  }
  return csv
}

def unidadeDeMedida (){
  
  fonteUnidadesMedida = Dados.obras.v1.unidadesMedida;
  dadosUnidadesMedida = fonteUnidadesMedida.busca(campos: "nome, simbolo, nomePlural, grandeza, fracionaria")
  
  
  csv = Arquivo.novo('unidadeDeMedida.csv','csv',[delimitador: ';' ])
  csv.escrever('descricao singular')
  csv.escrever('abreviatura')
  csv.escrever('descricao plural')
  csv.escrever('grandeza')
  csv.escrever('possui fracionamento')
  csv.novaLinha()
  
  percorrer (dadosUnidadesMedida) { itemUnidadesMedida ->
    
    csv.escrever(item.nome)
    csv.escrever(item.simbolo)
    csv.escrever(item.nomePlural)
    csv.escrever(item.grandeza)
    fracionariaString = item.fracionaria ? 'Sim' : 'Não'
    csv.escrever("${fracionariaString}")
    csv.novaLinha()
  }
  return csv
}


def responsaveisTecnicos (){
  
  fonteResponsaveisTecnicos = Dados.obras.v1.pessoas.responsaveisTecnicos;
  dadosResponsaveisTecnicos = fonteResponsaveisTecnicos.busca(campos: "pessoa(nome, cpfCnpj), tipoResponsavelTecnico(descricao), registro")
  
  
  csv = Arquivo.novo('responsaveisTecnicos.csv','csv',[delimitador: ';' ])
  csv.escrever('nome')
  csv.escrever('cpf')
  csv.escrever('tipo')
  csv.escrever('registro')
  csv.novaLinha()
  
  percorrer (dadosResponsaveisTecnicos) { itemResponsaveisTecnicos ->
    
    csv.escrever(item.pessoa.nome)
    csv.escrever(item.pessoa.cpfCnpj)
    csv.escrever(item.tipoResponsavelTecnico.descricao)
    csv.escrever(item.registro)
    csv.novaLinha()
  }
  return csv
}

def cnos (){
  
  fonteMatriculasCei = Dados.obras.v1.matriculasCei;
  dadosMatriculasCei = fonteMatriculasCei.busca(campos: "numeroMatricula, dataMatricula")
  
  
  csv = Arquivo.novo('cnos.csv','csv',[delimitador: ';' ])
  csv.escrever('numero matricula')
  csv.escrever('data matricula')
  csv.novaLinha()
  
  percorrer (dadosMatriculasCei) { itemMatriculasCei ->
    
    csv.escrever(item.numeroMatricula)
    csv.escrever(item.dataMatricula.formatar('dd/MM/yyyy'))
    csv.novaLinha()
  }
  return csv
}

def editandoObras (){
  
  fonteObras = Dados.obras.v1.obras;
  dadosObras = fonteObras.busca(campos: "codObra, descricao, objeto, dataCadastro, organograma(descricao), diasTermino, tipoObra(descricao), classificacao(descricao), quantidade, unidadeMedida(nome), categoria(descricao), tipoExecucao, obraProjeto, tipoEmpreitada, latitudeSaida, latitudeChegada, longitudeSaida, longitudeChegada, camposAdicionais(padrao(contDecLicitacao, sicomLinkObra, sicomVeiculoPublicacao, sicomDataPublicVeiculo))")
  
  fonteDestinacao = Dados.obras.v1.obras.destinacao;
  dadosDestinacao = fonteDestinacao.busca(campos: "idObra, destinoObra")
  
  //CRIAR MAPA DE ACESSO AO DESTINO OBRAS
  mapaDestinacao = [:]
  percorrer (dadosDestinacao) { itemDest ->
    mapaDestinacao[itemDest.idObra] = itemDest.destinoObra
  }
  
  
  csv = Arquivo.novo('editandoObras.csv','csv',[delimitador: ';' ])
  cabecalhos = [
    'codigo obra', 'descricao', 'objeto', 'data', 'organograma', 
    'Prazo de conclusão', 'tipo de obra', 'classificação', 'quantidade', 
    'unidade de medida', 'categoria', 'tipo de execução', 'obra/projeto', 
    'tipo de empreitada', 'obra destinada para', 'latitude inicial', 
    'longitude inicial', 'latitude final', 'longitude final',
    'contDecLicitacao', 'sicomLinkObra', 'sicomVeiculoPublicacao', 'sicomDataPublicVeiculo'
  ]
  
  percorrer (cabecalhos) { cabecalho ->
    csv.escrever(cabecalho)
  }
  csv.novaLinha()
  
  percorrer (dadosObras) { itemObras ->
    
    //BUSCA DESTINO CORRESPONDENTE
    destinoObra = mapaDestinacao[item.id] ?: "Não informado"
    
    csv.escrever(item.codObra ?: "")
    csv.escrever(item.descricao ?: "")
    csv.escrever(item.objeto ?: "")
    csv.escrever(item.dataCadastro.formatar('dd/MM/yyyy') ?: "")
    csv.escrever(item.organograma?.descricao ?: "")
    csv.escrever(item.diasTermino ?: "")
    csv.escrever(item.tipoObra?.descricao ?: "")
    csv.escrever(item.classificacao?.descricao ?: "")
    csv.escrever(item.quantidade ?: "")
    csv.escrever(item.unidadeMedida?.nome ?: "")
    csv.escrever(item.categoria?.descricao ?: "")
    csv.escrever(item.tipoExecucao ?: "")
    csv.escrever(item.obraProjeto ?: "")
    csv.escrever(item.tipoEmpreitada ?: "")
    csv.escrever(destinoObra) 
    csv.escrever(item.latitudeSaida ?: "")
    csv.escrever(item.longitudeSaida ?: "")
    csv.escrever(item.latitudeChegada ?: "")
    csv.escrever(item.longitudeChegada ?: "")
    
    // Campos adicionais
    csv.escrever(item.camposAdicionais?.padrao?.contDecLicitacao?.descricao ?: "")
    csv.escrever(item.camposAdicionais?.padrao?.sicomLinkObra ?: "")
    csv.escrever(item.camposAdicionais?.padrao?.sicomVeiculoPublicacao ?: "")
    csv.escrever(item.camposAdicionais?.padrao?.sicomDataPublicVeiculo.formatar('dd/MM/yyyy') ?: "")
    
    csv.novaLinha()
  }
  return csv
}

def inicioObras(){
  
  fonteHistoricos = Dados.obras.v1.obras.historicos;
  dadosHistoricos = fonteHistoricos.busca(campos: "situacaoNova, dhRealMovimento, obra(codObra, descricao)")
  
  
  csv = Arquivo.novo('inicioObras.csv','csv',[delimitador: ';' ])
  cabecalhos = [
    'codigo obra', 'descricao', 'data inicio', 'situacao'
  ]
  
  percorrer (cabecalhos) { cabecalho ->
    csv.escrever(cabecalho)
  }
  csv.novaLinha()
  percorrer (dadosHistoricos) { itemHistoricos ->
    if( item.situacaoNova == 'EM_ANDAMENTO'){
      csv.escrever(item.obra.codObra)
      csv.escrever(item.obra.descricao)
      csv.escrever(item.dhRealMovimento.formatar('dd/MM/yyyy'))
      csv.escrever(item.situacaoNova)
      csv.novaLinha()
    }
  }
  return csv
  
}


def obrasResponsabilidadeTec (){
  
  fonteAnotacoesTecnicas = Dados.obras.v1.obras.anotacoesTecnicas;
  dadosAnotacoesTecnicas = fonteAnotacoesTecnicas.busca(campos: "obra(codObra, descricao), dataInclusao, nroResponsabilidadeTecnica, tipoResponsabilidade(descricao), responsavelTecnico(pessoa(nome))")
  
  csv = Arquivo.novo('obrasResponsabilidadeTec.csv','csv',[delimitador: ';' ])
  cabecalhos = [
    'codigo obra', 'descricao', 'data inclusao', 'nro responsabilidade', 'tipo responsabiliade', 'nome responsavel'
  ]
  
  percorrer (cabecalhos) { cabecalho ->
    csv.escrever(cabecalho)
  }
  
  
  
  percorrer (dadosAnotacoesTecnicas) { itemAnotacoesTecnicas ->
    csv.escrever(item.obra.codObra)
    csv.escrever(item.obra.descricao)
    csv.escrever(item.dataInclusao.formatar('dd/MM/yyyy'))
    csv.escrever(item.nroResponsabilidadeTecnica)
    csv.escrever(item.tipoResponsabilidade.descricao)
    csv.escrever(item.responsavelTecnico.pessoa.nome)
    csv.novaLinha()    
  }
  return csv
  
}

def obrasCNOS(){
  
  fonteMatriculas = Dados.obras.v1.obras.matriculas;
  dadosMatriculas = fonteMatriculas.busca(campos: "obra(codObra, descricao), matriculaCei(numeroMatricula), dataMatriculaObra")
  
  csv = Arquivo.novo('obrasCNOS.csv','csv',[delimitador: ';' ])
  cabecalhos = [
    'codigo obra', 'descricao', 'matricula', 'data matricula'
  ]
  
  percorrer (cabecalhos) { cabecalho ->
    csv.escrever(cabecalho)
  }
  csv.novaLinha()  
  
  percorrer (dadosMatriculas) { itemMatriculas ->
    
    csv.escrever(item.obra.codObra)
    csv.escrever(item.obra.descricao)
    csv.escrever(item.matriculaCei.numeroMatricula)
    csv.escrever(item.dataMatriculaObra.formatar('dd/MM/yyyy') )
    csv.novaLinha()  
  }
  return csv
  
}


def obraslicitacoes(){
  
  fonteLicitacoes = Dados.obras.v1.obras.licitacoes;
  dadosLicitacoes = fonteLicitacoes.busca(campos: "processoAdministrativo(nroProcAdm, anoProcAdm), obra(codObra, descricao), dataInclusao, numeroProcesso, anoProcesso")
  
  csv = Arquivo.novo('obrasLicitacoes.csv','csv',[delimitador: ';' ])
  cabecalho = [
    'codigo obra', 'descricao', 'n processo', 'ano processo', 'data inclusao'
  ]
  percorrer(cabecalho){ cabecalho ->
    csv.escrever(cabecalho)
  }
  csv.novaLinha()  
  
  percorrer (dadosLicitacoes) { itemLicitacoes ->
    csv.escrever(item.obra.codObra)
    csv.escrever(item.obra.descricao)
    csv.escrever(item.numeroProcesso)
    csv.escrever(item.anoProcesso)
    csv.escrever(item.dataInclusao.formatar('dd/MM/yyyy'))
    csv.novaLinha()  
    
  }
  return csv
  
}


def obrasContratosAditivos(){
  
  fonteContratos = Dados.obras.v1.obras.contratos;
  dadosContratos = fonteContratos.busca(campos: "numeroContrato, anoContrato, dataInclusaoContrato, obra(codObra, descricao)")
  
  fonteAditivos = Dados.obras.v1.obras.aditivos;
  dadosAditivos = fonteAditivos.busca(campos: "obra(codObra, descricao), dataInclusaoAditivo, aditivo(nroAditivo, contrato(nroContrato, anoContrato))")
  
  // MAPA DE ADITIVOS AGRUPADOS POR CONTRATO
  // Chave: "numeroContrato|anoContrato"
  // Valor: lista de aditivos para esse contrato
  mapaAditivosPorContrato = [:]
  
  percorrer (dadosAditivos) { itemAditivo ->
    chaveContrato = itemAditivo.aditivo.contrato.nroContrato + "|" + itemAditivo.aditivo.contrato.anoContrato
    
    if (!mapaAditivosPorContrato[chaveContrato]) {
      mapaAditivosPorContrato[chaveContrato] = []
    }
    
    // Adiciona o aditivo à lista do contrato
    mapaAditivosPorContrato[chaveContrato]<<([
      nroAditivo: itemAditivo.aditivo.nroAditivo,
      dataInclusaoAditivo: itemAditivo.dataInclusaoAditivo,
      obraCodigo: itemAditivo.obra.codObra,
      obraDescricao: itemAditivo.obra.descricao
    ])
  }
  
  csv = Arquivo.novo('obrasContratosAditivos.csv','csv',[delimitador: ';'])
  cabecalho = [
    'codigo obra', 'descricao', 'n contrato', 'ano contrato', 
    'data inclusao contrato', 'n aditivo', 'data inclusao aditivo'
  ]
  
  percorrer(cabecalho){ campo ->
    csv.escrever(campo)
  }
  csv.novaLinha()  
  
  percorrer (dadosContratos) { itemContrato ->  // Nome correto da variável
    
    // CHAVE PARA BUSCAR NO MAPA
    chaveContrato = itemContrato.numeroContrato + "|" + itemContrato.anoContrato
    
    // BUSCAR ADITIVOS DESTE CONTRATO
    aditivosDoContrato = mapaAditivosPorContrato[chaveContrato] ?: []
    
    if (aditivosDoContrato.size() > 0) {
      // SE TEM ADITIVOS: escreve uma linha para cada aditivo
      percorrer (aditivosDoContrato) { aditivo ->
        csv.escrever(itemContrato.obra.codObra ?: aditivo.obraCodigo ?: "")
        csv.escrever(itemContrato.obra.descricao ?: aditivo.obraDescricao ?: "")
        csv.escrever(itemContrato.numeroContrato)
        csv.escrever(itemContrato.anoContrato)
        csv.escrever(itemContrato.dataInclusaoContrato.formatar('dd/MM/yyyy') ?: "")
        csv.escrever(aditivo.nroAditivo ?: "")
        csv.escrever(aditivo.dataInclusaoAditivo?.formatar('dd/MM/yyyy') ?: "")
        csv.novaLinha()
      }
    } else {
      // SE NÃO TEM ADITIVOS: escreve apenas o contrato
      csv.escrever(itemContrato.obra.codObra ?: "")
      csv.escrever(itemContrato.obra.descricao ?: "")
      csv.escrever(itemContrato.numeroContrato)
      csv.escrever(itemContrato.anoContrato)
      csv.escrever(itemContrato.dataInclusaoContrato.formatar('dd/MM/yyyy') ?: "")
      csv.escrever("") // n aditivo vazio
      csv.escrever("") // data inclusao aditivo vazia
      csv.novaLinha()
    }
  }
  
  return csv
}



//CHAMADA DAS FUNÇÕES PARA PASTA ZIP
/*
------FEITO O CADASTRO DIA 26/11------


def cadastrosAuxiliares(){
arquivo = Arquivo.novo('cadastrosAuxiliares.zip', 'zip')

arquivo.adicionar(classificacaoTipoObra())
arquivo.adicionar(motivosDeParalisacao())
arquivo.adicionar(tiposDeObra())
arquivo.adicionar(tiposderesponsabilidades())
arquivo.adicionar(tiposderesponsaveis())
arquivo.adicionar(tipodemedicao())
Resultado.arquivo(arquivo)
}

*/



// EXPORTAR ANEXOS DE OBRAS
def anexosObras() {
  zip = Arquivo.novo("anexosObras.zip", "zip")
  fonteAnexos = Dados.obras.v1.obras.anexos;
  dadosAnexos = fonteAnexos.busca(campos: "obra(codObra), urlAnexo, anexo(nome)")
  
  percorrer (dadosAnexos) { itemAnexos ->
    codObra = item.obra.codObra
    urlAnexo = item.urlAnexo
    nome = item.anexo.nome
    
    // Cria diretório dentro do ZIP com o código da obra
    zip.criarDiretorio("${codObra}")
    resposta = Http.servico(urlAnexo)
    .aceitarTipoMidia(Http.ARQUIVO)
    .GET()
    
    arquivo = resposta.arquivo()
    
    // Adiciona o arquivo DENTRO da pasta da obra
    zip.adicionar(arquivo, "${nome}","${codObra}")
    
    
  }
  
  Resultado.arquivo(zip)
}






def demaisCadastros(){
  arquivo = Arquivo.novo('demaisCadastros.zip', 'zip')
  //----- FEITO O CADASTRO DIA 27/11 -----
  //arquivo.adicionar(unidadeDeMedida())
  //arquivo.adicionar(responsaveisTecnicos())
  //arquivo.adicionar(cnos())
  
  
  //arquivo.adicionar(editandoObras())
  arquivo.adicionar(inicioObras())
  arquivo.adicionar(obrasResponsabilidadeTec ())
  arquivo.adicionar(obrasCNOS())
  arquivo.adicionar(obraslicitacoes())
  arquivo.adicionar(obrasContratosAditivos())
  Resultado.arquivo(arquivo)
}

//cadastrosAuxiliares()
demaisCadastros()
//anexosObras()