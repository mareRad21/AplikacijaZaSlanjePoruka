package model;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class AppendableObjectOutputStream  extends ObjectOutputStream{

	public AppendableObjectOutputStream(OutputStream out) throws IOException {
		super(out);
		// TODO Auto-generated constructor stub
	}
	@Override
	protected void writeStreamHeader() throws IOException {
	
		
	}

}
