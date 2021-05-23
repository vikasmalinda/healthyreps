package com.project.sapient.interfaces;

import java.util.List;

import com.project.sapient.entity.Gallery;

public interface IGalleryDao {
	public boolean insertNewImage(Gallery user);

	public List<Gallery> getAllImages();
}
