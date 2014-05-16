package indumaticsgestion.data.comun;

public class ClientConfig {

    private Host host;

    public ClientConfig(Host host) {
        this.host = host;
    }

    public ClientConfig() {
        this.host = new Host("localhost", 8080);
    }

    public Host getHost() {
        return host;
    }

    public void setHost(Host host) {
        this.host = host;
    }

}
