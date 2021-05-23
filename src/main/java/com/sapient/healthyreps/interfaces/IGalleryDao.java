package com.sapient.healthyreps.interfaces;

import java.util.List;

import com.sapient.healthyreps.entity.Gallery;

public interface IGalleryDao {
	public boolean insertNewImage(Gallery user);

	public List<Gallery> getAllImages();
}
