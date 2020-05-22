package com.pattern.behavioral.memento;
/*
Originator class
*/
public class FileWriteUtil {
	private String fileName;
	private StringBuilder content;
	
	public FileWriteUtil(String theFileName, StringBuilder theContent) {
		this.fileName = theFileName;
		this.content = theContent;
	}
	
	public void write(String string) {
		this.content.append(" ").append(string);
	}
	
	public Object save() {
		Memento memento = new Memento();
		memento.setFileName(this.fileName);
		memento.setContent(this.content);
		
		return memento;
	}
	
	public void undoToLastSave(Object obj) {
		Memento memento = (Memento)obj;
		this.fileName = memento.getFileName();
		this.content = memento.getContent();
	}
	
	@Override
	public String toString() {
		return content.toString();
	}
/*	
***	Memento class
*/
	public class Memento {
		private String fileName;
		private StringBuilder content;
		
		private String getFileName() {
			return fileName;
		}
		private void setFileName(String fileName) {
			this.fileName = fileName;
		}
		private StringBuilder getContent() {
			return content;
		}
		private void setContent(StringBuilder content) {
			this.content = new StringBuilder(content);
		}
	}

}
