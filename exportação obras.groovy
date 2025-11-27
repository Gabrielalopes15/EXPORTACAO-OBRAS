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
  
  
  arquivo.adicionar(editandoObras())
  
  Resultado.arquivo(arquivo)
}

//cadastrosAuxiliares()
demaisCadastros()
anexosObras()