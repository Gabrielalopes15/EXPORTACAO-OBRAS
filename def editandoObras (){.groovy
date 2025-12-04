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
