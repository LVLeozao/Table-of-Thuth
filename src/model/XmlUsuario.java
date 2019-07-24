package model;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.Dom4JDriver;

public class XmlUsuario {
	private XStream xStream;
	private File file;
	private ArrayList<Protagonista> protagonistas;

	public XmlUsuario() {
		this.xStream = new XStream(new Dom4JDriver());
		xStream.processAnnotations(Protagonista.class);
		xStream.alias("tempoFases", String.class);

		file = new File("src/arquivos/usuarios.xml");
		protagonistas = new ArrayList<Protagonista>();

	}

	public void salvar(Protagonista protagonista) {

		protagonistas.add(protagonista);

		try {
			if (!file.exists())
				file.createNewFile();
			else {
				file.delete();
				file.createNewFile();
			}

			OutputStream stream = new FileOutputStream(file);
			xStream.toXML(protagonista, stream);

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@SuppressWarnings("unchecked")
	public List<Protagonista> ler() {
		try {
			if (!file.exists())
				file.createNewFile();
			else {
				return (List<Protagonista>) xStream.fromXML(file);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;

	}

	public List<Protagonista> getQuestaos() {
		return protagonistas;
	}

	

}
