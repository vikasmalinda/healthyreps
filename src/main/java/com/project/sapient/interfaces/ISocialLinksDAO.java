package com.project.sapient.interfaces;

import java.util.List;

import com.project.sapient.entity.SocialLinks;

public interface ISocialLinksDAO {

	public boolean insertUrls(SocialLinks user);

	public List<SocialLinks> getAlLUrls();

}
