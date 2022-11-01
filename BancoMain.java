package banco;

public class BancoMain {

    public static void main(String[] args) {
        ContaBanco p1 = new ContaBanco();
        p1.setDono("william");
        p1.setNumCont(25252525);
        p1.abrirConta("CC");
       
        
        
        ContaBanco p2 = new ContaBanco();
        p2.setNumCont(2626262);
        p2.setDono("Larissa");
        p2.abrirConta("CP");
        
        p1.depositar(300);
        p2.depositar(500);
        p2.sacar(235);
        
        p1.fecharConta();
        p1.sacar(350);
        p1.fecharConta();
        
        p2.pagarMensal();
        
        p2.estadoAtual();
        p1.estadoAtual();
    }
    
}
