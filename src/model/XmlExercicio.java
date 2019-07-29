package model;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.Dom4JDriver;

public class XmlExercicio {
	private XStream xStream;
	private File file;
	private ArrayList<Exercicio> exercicios;

	public XmlExercicio() {
		this.xStream = new XStream(new Dom4JDriver());
		xStream.processAnnotations(Protagonista.class);
		xStream.alias("tempoFases", Protagonista.class);

		file = new File("src/arquivos/exercicios.xml");
		exercicios = new ArrayList<Exercicio>();

	}
	
	public Exercicio buscar(Exercicio exercicio){
		for (Exercicio exe : exercicios) {
			if(exe.getId() == exercicio.getId()){
				return exe;
			}
		}
		return null;
	}
	public void remover(Exercicio exercicio){
		Exercicio temp = buscar(exercicio);
		
		if(temp != null){
			exercicios.remove(temp);
			

			try {
				if (!file.exists())
					file.createNewFile();
				else {
					file.delete();
					file.createNewFile();
				}
				
				OutputStream stream = new FileOutputStream(file);
				xStream.toXML(exercicios, stream);
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}

	public void salvar(Exercicio exercicio) {
			
		exercicios.add(exercicio);
	
			try {
				if (!file.exists())
					file.createNewFile();
				else {
					file.delete();
					file.createNewFile();
				}
				
				OutputStream stream = new FileOutputStream(file);
				xStream.toXML(exercicios, stream);
				
			} catch (IOException e) {
				e.printStackTrace();
			}
	
		}
	
	
	public List<Exercicio> ler()
	{
		try {
			if (!file.exists())
				file.createNewFile();
			else {
				
				this.exercicios = (ArrayList<Exercicio>) xStream.fromXML(file);
				
				return this.exercicios;
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (com.thoughtworks.xstream.io.StreamException e) {
			;
		}

		return new ArrayList<Exercicio>();
		
	}

	public List<Exercicio> getQuestaos() {
		return exercicios;
	}

}
