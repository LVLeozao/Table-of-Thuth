package model;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

import javax.imageio.ImageIO;

public class Camada{
	public  BufferedImage camada;
	private BufferedImage tileSet;
	private  int mapaQtnColunas;
	private  int mapaQntLinhas;
	public  int mapa[][];
	private  int tileLargura;
	private  int tileAltura;
	ArrayList<Rectangle> bausColisao = new ArrayList<>();
	
	
	
	
	public Camada(String tileImg, String arquivo, int mapaQtnColunas, int mapaQntLinhas, int tileLargura, int tileAltura) {
		this.mapaQtnColunas = mapaQtnColunas;
		this.mapaQntLinhas = mapaQntLinhas;
		this.tileLargura = tileLargura;
		this.tileAltura = tileAltura;
		
		this.mapa = new int[mapaQntLinhas][mapaQtnColunas];
		this.mapa = carregaMatriz(mapa, arquivo);
		try {
			this.tileSet = ImageIO.read(getClass().getClassLoader().getResource(tileImg));
		} catch (IOException e) {
			System.out.println("Erro ao tileSet.\nEncerrando aplicação");
			System.exit(0);
		}
	}

	public int[][] carregaMatriz(int[][] matz, String arquivo) {
		ArrayList<String> linhasMatrizCamada = new ArrayList<String>();
		InputStream is = getClass().getClassLoader().getResourceAsStream (arquivo);
		BufferedReader br = new BufferedReader (new InputStreamReader (is));   
		String linha="";
		try {

			while ((linha = br.readLine()) != null){
				linhasMatrizCamada.add(linha);
			}
			int j = 0;
			for (int i = 0; i < linhasMatrizCamada.size(); i++) {
				StringTokenizer token = new StringTokenizer(linhasMatrizCamada.get(i), ",");
			
				while (token.hasMoreElements()) {	
					matz[i][j] = Integer.parseInt(token.nextToken());
					j++;
				}
				j = 0;
			}
		} catch (FileNotFoundException fileNotFoundException) {
			System.out.println("nao carregou arquivo mapa");
			System.exit(0);
		}
		catch (IOException ioException) {
			System.out.println("erro na leitura do mapa");
			System.exit(0);
		}
		return matz;
	}
	
	public void montarMapa(int lar, int alt) {

		camada = new BufferedImage(lar, alt, BufferedImage.TYPE_4BYTE_ABGR);
		camada.createGraphics();

		int tile;
		int tileRow;
		int tileCol;
		int colunasTileSet=tileSet.getWidth()/tileLargura;
		
		
		for (int i = 0; i < mapaQntLinhas  ; i++) {
			for (int j = 0; j <mapaQtnColunas ; j++) {
				
				tile = (mapa[i][j] != 0) ? (mapa[i][j]-1) : 1;
		
	
				tileRow = (tile / (colunasTileSet)) | 0;
				tileCol = (tile % (colunasTileSet)) | 0;
				camada.getGraphics().drawImage(tileSet, (j * tileAltura), (i * tileLargura), (j * tileAltura) + tileAltura,
						(i * tileLargura) + tileLargura, (tileCol * tileAltura), (tileRow * tileLargura),
						(tileCol * tileAltura) + tileAltura, (tileRow * tileLargura) + tileLargura, null);
			}
		}
	
		
	}
	
	public ArrayList<Rectangle> montarColisao() {
		ArrayList<Rectangle> tmp=new ArrayList<>();
	
		//calcula as partes do mapa que o player nao podera atravessar
		for (int i = 0; i < mapaQntLinhas; i++) {
			for (int j = 0; j < mapaQtnColunas; j++) {
				if(mapa[i][j] == 2){
					bausColisao.add(new Rectangle( (j * tileAltura), (i * tileAltura), tileAltura, tileAltura));
				}
				if(mapa[i][j] != 0) {
					tmp.add(new Rectangle( (j * tileAltura), (i * tileAltura), tileAltura, tileAltura));
				}
			}
		}
		
		

		return tmp;
	}

	public ArrayList<Rectangle> getBausColisao() {
		return bausColisao;
	}
	
	
	
	
	
	
	
}
