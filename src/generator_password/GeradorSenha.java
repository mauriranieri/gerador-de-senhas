package generator_password;

public class GeradorSenha {
    
    private final String letrasMaiusculas = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"; 
    private final String letrasMinusculas = "abcdefghijklmnopqrstuvwxyz"; 
    private final String numeros = "1234567890"; 
    private final String simbolos = "/_¨-,.[]^%$#@&"; 

    public String gerarSenha(int tamanho) {
        String senha = "";

        for(int i = 0; i < tamanho; i++) {
            switch ((int) (Math.random() * 4)) {
                case 0: senha += gerarCaractere(letrasMaiusculas);
                        break;
                case 1: senha += gerarCaractere(letrasMinusculas);
                        break;
                case 2: senha += gerarCaractere(numeros);
                        break;
                case 3: senha += gerarCaractere(simbolos);
                        break;
            }
        }

        return senha;
    }

    private char gerarCaractere(String tipoCaractere) {
        int index = (int) (Math.random() * tipoCaractere.length());
        return tipoCaractere.charAt(index);
    }
}
