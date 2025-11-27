

// URL de teste
/*
zip = Arquivo.novo("teste.zip", "zip")
resposta = Http.servico("https://teste.pdf")
.aceitarTipoMidia(Http.ARQUIVO)
.GET()

arquivo = resposta.arquivo()

zip.adicionar(arquivo)
Resultado.arquivo(zip)
*/

zip = Arquivo.novo("anexosObras.zip", "zip")
fonteAnexos = Dados.obras.v1.obras.anexos;
dadosAnexos = fonteAnexos.busca(campos: "obra(codObra), urlAnexo, anexo(nome)")

percorrer (dadosAnexos) { itemAnexos ->
  codObra = item.obra.codObra
  urlAnexo = item.urlAnexo
  nome = item.anexo.nome
  
  zip.criarDiretorio("${codObra}")// Cria diretório dentro do ZIP com o código da obra
  resposta = Http.servico(urlAnexo)
  .aceitarTipoMidia(Http.ARQUIVO)
  .GET()
  
  arquivo = resposta.arquivo()
  
  // Adiciona o arquivo DENTRO da pasta da obra
  zip.adicionar(arquivo, "${nome}","${codObra}")
  
  
}

Resultado.arquivo(zip)
