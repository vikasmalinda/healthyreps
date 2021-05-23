package com.sapient.healthyreps.exception;

public class ImageAlreadyPresent extends Exception {
	String url;

	public ImageAlreadyPresent(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return "ImageAlreadyPresent [url=" + url + "]";
	}
}
