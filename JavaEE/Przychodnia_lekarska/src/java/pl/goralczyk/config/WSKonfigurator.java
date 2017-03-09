package pl.goralczyk.config;

import javax.servlet.http.HttpSession;
import javax.websocket.HandshakeResponse;
import javax.websocket.server.HandshakeRequest;
import javax.websocket.server.ServerEndpointConfig;
import pl.goralczyk.controllers.UzytkownikBean;

public class WSKonfigurator extends ServerEndpointConfig.Configurator{
    @Override
    public void modifyHandshake(ServerEndpointConfig sec, HandshakeRequest req, HandshakeResponse res){
        super.modifyHandshake(sec, req, res);
        UzytkownikBean ub = (UzytkownikBean) ((HttpSession)req.getHttpSession()).getAttribute("uzytkownikBean");
        sec.getUserProperties().put("uzytkownik", ub.getLogin());
    }
}
