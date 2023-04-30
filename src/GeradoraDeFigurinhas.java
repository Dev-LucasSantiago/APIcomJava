import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;
import javax.imageio.ImageIO;

public class GeradoraDeFigurinhas {

    public void cria(InputStream inputStream, String nomeArquivo) throws Exception{
        //Leitura da imagem
        //InputStream inputStream =
        // new FileInputStream("entrada/filme.jpg");
        //InputStream inputStream =
        // new URL("https://m.media-amazon.com/images/M/MV5BNDE3ODcxYzMtY2YzZC00NmNlLWJiNDMtZDViZWM2MzIxZDYwXkEyXkFqcGdeQXVyNjAwNDUxODI@.jpg").openStream();
        BufferedImage imagemOriginal = ImageIO.read(inputStream);

        //cria imagem nova com transparência
        int largura = imagemOriginal.getWidth();
        int altura = imagemOriginal.getHeight();
        int novaAltura = altura + 200;
        BufferedImage novaImagem = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);

        //Copiar a imagem original para novo imagem (em memória)
        Graphics2D graphics = (Graphics2D) novaImagem.getGraphics();
        graphics.drawImage(imagemOriginal, 0,0,null);

        //Configurar a fonte
        Font fonte = new Font(Font.SANS_SERIF,Font.BOLD,128);
        graphics.setColor(Color.yellow);
        graphics.setFont(fonte);

        //Escrever uma frase em nova imagem
        graphics.drawString("TOPZERA",300,novaAltura - 50);

        //Escrever a nova imagem em arquivo
        ImageIO.write(novaImagem,"png",new File("saida/"+nomeArquivo));
    }
}
