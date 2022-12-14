package banco;

public class ContaBanco {
    //ATRIBUTOS...............................................................................................................................
    public int numCont;
    protected String tipo;
    private String dono;
    private float saldo;
    private boolean status;
    
    //MÉTODOS...............................................................................................................................
    
    public void estadoAtual(){
        System.out.println("--------------------------------------------------");
        System.out.println("conta: " +this.getNumCont());
        System.out.println("tipo: " +this.getTipo());
        System.out.println("dono: " +this.getDono());
        System.out.println("saldo: " +this.getSaldo());
        System.out.println("status: "+this.getStatus());
    }
    
    public void abrirConta(String t){       //recebe uma STRING // quando é chamado ele ja muda o status pra true(ex abaixo)
        this.setStatus(true); //modifica que a conta esta criado
        this.setTipo(t); //declaro que o tipo recebe o parametro string t //é esperado a entrada do usuario se pe cc ou cp
        if (t == "CC") { //se for criado conta corrente tera um saldo de 50
            this.setSaldo(50);
        } else if (t == "CP"){//se for criado conta corrente tera um saldo de 150
           this.setSaldo(150); 
           }
        System.out.println("CONTA ABERTA COM SUCESSO "+this.getDono());
    }
    
    public void fecharConta(){
        if (this.getSaldo() > 0 ){          //é get pq ele não vai modificar nada, so vai vereficar o atributo saldo
            System.out.println("não pode ser fechada porque tem dinheito na conta "+this.getDono());
        }else if (this.getSaldo() < 0){
            System.out.println("não pode ser fechada, conta em debito, faça os pagamentos "+this.getDono());
        }else{
            this.setStatus(false);      //VAI MODIFICAR O STATUS PARA FALSO
            System.out.println("CONTA FECHADA COM SUCESSO "+this.getDono());
        }
    }
    
    public void depositar(float v){ //recebe o valor que for inserido
        if (this.getStatus()){ //verifica se esta aberta se n estiver ele pula para o else
//            this.saldo= this.saldo + v;             
            this.setSaldo (this.getSaldo() + v); //1° pega(get) o saldo atual soma com "Valor que foi depositado" 2°e modifica(set) no saldo 
            System.out.println("deposito realizado com sucesso na conta de "+this.getDono());
        }else {
            System.out.println("impossivel depositar pq a conta esta fechada "+this.getDono());
        }
    }
    
    public void sacar(float v){ //recebe o valor que for inserido
        if (this.getStatus()) { //verifica se a conta ta aberta
            if (this.getSaldo() >= v){ //verifica se o saldo é maior que o valor que ele quer sacar
                this.setSaldo(this.getSaldo() - v); //agora o valor que foi debitado em sacar, vai ser retirado de getsaldo(atual) e modificado por setsaldo que se tornara o valor de saldo - saque
                System.out.println("Saque realizado na conta de  "+this.getDono());
            }else{
                System.out.println("saldo insuficiente para saque de: "+this.getDono());
            }
        } else {
            System.out.println("impossivel sacar de uma conta fechada: "+this.getDono());  //else esta dentro do if status
        }
    }
    
    public void pagarMensal(){
        float v = 0; //é criado uma variavel v para usar como parametro nesse metodo// é criado pq ele n vai inserir nada de valor
        if (this.getTipo() == "CC"){ //vai verificar qual tipo de conta e colocar qual mensalidade ele possui
            v = 12;
        }else if (this.getTipo() == "CP"){
            v = 20;
        }
        if (this.getStatus()){//verifica se esta aberta se esta ele vai pagar a mensalidade
            this.setSaldo(this.getSaldo() - v);
            System.out.println("mensalidade paga com sucesso pelo "+this.getDono());
        }else{ //mesmo if de status
            System.out.println("impossivel pagar uma conta fechada "+this.getDono());
        }
         
    }
    
    //MÉTODOS ESPECIAIS...............................................................................................................................
    
    public ContaBanco() {           //MÉTODO CONTRUTOR
        this.saldo = 0;
        this.status = false;
    }
    
    public int getNumCont() {
        return numCont;
    }
    public void setNumCont(int numCont) {
        this.numCont = numCont;
    }

    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDono() {
        return dono;
    }
    public void setDono(String dono) {
        this.dono = dono;
    }

    public float getSaldo() {
        return saldo;
    }
    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public boolean getStatus() {
        return status;
    }
    public void setStatus(boolean status) {
        this.status = status;
    }

    
   
    
}
