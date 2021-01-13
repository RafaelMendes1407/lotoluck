package br.com.lotoluck.lotoluck.errors;

public class ErroDeFormulario {
    private String campo;
    private String msg;

    public ErroDeFormulario(String campo, String msg){
        this.msg = msg;
        this.campo = campo;
    }

    public ErroDeFormulario(){
    }

    public String getCampo() {
        return campo;
    }

    public void setCampo(String campo) {
        this.campo = campo;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}