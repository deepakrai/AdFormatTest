package com.inmobi.sdk.test.config;

public enum TestCaseTags {
	
	TestCase("TestCase"),
	SDK("SDK"),
	AndroidOS("AndroidOS"),
	AdType("AdType"),
	CTA("CTA"),
	CTA_URL("CTA_URL"),
	Ad("Ad"),
	AdUrl("AdUrl"),
		
		
	TestCaseFileName("TestCaseFileName"),
	
	Configs("Configs"),
	ExpandableAdFile("ExpandableAdFile"),
	AdMainFile("AdMainFile"),
	Pages("Pages"),
	Page("Page"),
	NextPageTap("NextPageTap"),
	PageTestType("PageTestType"),
	AutoPlay("AutoPlay"),
	Fullscreen("Fullscreen"),
	Image("Image"),
	Video("Video"),
	Audio("Audio"),
	Links("Links"),
	Link("Link"),
	Call("Call"),
	SMS("SMS"),
	Email("Email"),
	Facebook("Facebook"),
	Twitter("Twitter"),
	Pdf("Pdf"),
	Calendar("Calendar"),
	Animation("Animation"),
	Form("Form"),
	
	
	Last("Last");
	
	
	private String tagName;
	
	private TestCaseTags(String tagName) {
		this.tagName = tagName;
	}
	
	public String getName() {
		return tagName;
	}

}
