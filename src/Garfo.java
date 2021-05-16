//Trabalho problema dos filosofos - Sistemas Operacionais
//Gabriel Braz e Santos - 260569

public class Garfo {
    // status 1 - Disponivel
    // status 2 - Ocupado
    private int status = 1;
    private int id;

    Garfo(int id){
        this.id = id;
    }

    public int getId(){
        return this.id;
    }

    public int getStatus()
    {
        return status;
    }

    public String getTypeStatus(){
        switch(this.status) {
            case 1:
                return "Disponivel";
            case 2:
                return "Ocupado";
            default:
                return "Desconhecido";
        }
    }

    public void setStatus(int status)
    {
        this.status = status;
    }
}