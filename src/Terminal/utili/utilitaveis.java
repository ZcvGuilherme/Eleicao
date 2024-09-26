package Terminal.utili;

public class utilitaveis {
    public static void limpaTela() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    
    public static void SlowPrint(String message, long millisPerChar) {
        for (char ch : message.toCharArray()) {
            System.out.print(ch);
            try {
                Thread.sleep(millisPerChar);  // Pausa entre os caracteres
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println();  // Quebra de linha após a impressão completa
    }
    
}



