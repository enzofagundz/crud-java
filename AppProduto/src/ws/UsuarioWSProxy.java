package ws;

public class UsuarioWSProxy implements ws.UsuarioWS {
  private String _endpoint = null;
  private ws.UsuarioWS usuarioWS = null;
  
  public UsuarioWSProxy() {
    _initUsuarioWSProxy();
  }
  
  public UsuarioWSProxy(String endpoint) {
    _endpoint = endpoint;
    _initUsuarioWSProxy();
  }
  
  private void _initUsuarioWSProxy() {
    try {
      usuarioWS = (new ws.UsuarioWSServiceLocator()).getUsuarioWSPort();
      if (usuarioWS != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)usuarioWS)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)usuarioWS)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (usuarioWS != null)
      ((javax.xml.rpc.Stub)usuarioWS)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public ws.UsuarioWS getUsuarioWS() {
    if (usuarioWS == null)
      _initUsuarioWSProxy();
    return usuarioWS;
  }
  
  public ws.Usuario getUsuarioByLogin(java.lang.String arg0) throws java.rmi.RemoteException{
    if (usuarioWS == null)
      _initUsuarioWSProxy();
    return usuarioWS.getUsuarioByLogin(arg0);
  }
  
  public ws.Usuario[] getAllUsuarios() throws java.rmi.RemoteException{
    if (usuarioWS == null)
      _initUsuarioWSProxy();
    return usuarioWS.getAllUsuarios();
  }
  
  public void cadastrarUsuario(java.lang.String arg0, java.lang.String arg1, java.lang.String arg2, java.lang.String arg3, java.lang.String arg4) throws java.rmi.RemoteException{
    if (usuarioWS == null)
      _initUsuarioWSProxy();
    usuarioWS.cadastrarUsuario(arg0, arg1, arg2, arg3, arg4);
  }
  
  public void removerUsuario(java.lang.String arg0) throws java.rmi.RemoteException{
    if (usuarioWS == null)
      _initUsuarioWSProxy();
    usuarioWS.removerUsuario(arg0);
  }
  
  public void atualizarUsuario(java.lang.String arg0, java.lang.String arg1, java.lang.String arg2, java.lang.String arg3, java.lang.String arg4) throws java.rmi.RemoteException{
    if (usuarioWS == null)
      _initUsuarioWSProxy();
    usuarioWS.atualizarUsuario(arg0, arg1, arg2, arg3, arg4);
  }
  
  
}