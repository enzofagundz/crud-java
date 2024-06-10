package ws;

public class ProdutoWSProxy implements ws.ProdutoWS {
  private String _endpoint = null;
  private ws.ProdutoWS produtoWS = null;
  
  public ProdutoWSProxy() {
    _initProdutoWSProxy();
  }
  
  public ProdutoWSProxy(String endpoint) {
    _endpoint = endpoint;
    _initProdutoWSProxy();
  }
  
  private void _initProdutoWSProxy() {
    try {
      produtoWS = (new ws.ProdutoWSServiceLocator()).getProdutoWSPort();
      if (produtoWS != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)produtoWS)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)produtoWS)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (produtoWS != null)
      ((javax.xml.rpc.Stub)produtoWS)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public ws.ProdutoWS getProdutoWS() {
    if (produtoWS == null)
      _initProdutoWSProxy();
    return produtoWS;
  }
  
  public void cadastrarProduto(java.lang.String arg0, java.lang.String arg1, java.lang.String arg2, java.lang.String arg3) throws java.rmi.RemoteException{
    if (produtoWS == null)
      _initProdutoWSProxy();
    produtoWS.cadastrarProduto(arg0, arg1, arg2, arg3);
  }
  
  public void removerProduto(java.lang.String arg0) throws java.rmi.RemoteException{
    if (produtoWS == null)
      _initProdutoWSProxy();
    produtoWS.removerProduto(arg0);
  }
  
  public void atualizarProduto(java.lang.String arg0, java.lang.String arg1, java.lang.String arg2, java.lang.String arg3, java.lang.String arg4) throws java.rmi.RemoteException{
    if (produtoWS == null)
      _initProdutoWSProxy();
    produtoWS.atualizarProduto(arg0, arg1, arg2, arg3, arg4);
  }
  
  public ws.Produto[] getAllProdutos() throws java.rmi.RemoteException{
    if (produtoWS == null)
      _initProdutoWSProxy();
    return produtoWS.getAllProdutos();
  }
  
  public ws.Produto getProdutoById(java.lang.String arg0) throws java.rmi.RemoteException{
    if (produtoWS == null)
      _initProdutoWSProxy();
    return produtoWS.getProdutoById(arg0);
  }
  
  
}