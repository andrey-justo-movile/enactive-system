package com.social.enactive.bot.integration.microsoft.face.response.attributes;

import java.util.List;
import java.util.Map;

public class Attributes {

	private int age;
	private String gender;
	private float smile;
	private String glasses;
	private FacialHair facialHair;
	private HeadPose headPose;
	private Map<String, Float> emotion;
	private Hair hair;
	private Makeup makeup;
	private Occlusion occlusion;
	private List<Accessory> accessories;
	private Blur blur;
	private Exposure exposure;
	private Noise noise;

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public float getSmile() {
		return smile;
	}

	public void setSmile(float smile) {
		this.smile = smile;
	}

	public String getGlasses() {
		return glasses;
	}

	public void setGlasses(String glasses) {
		this.glasses = glasses;
	}

	public FacialHair getFacialHair() {
		return facialHair;
	}

	public void setFacialHair(FacialHair facialHair) {
		this.facialHair = facialHair;
	}

	public HeadPose getHeadPose() {
		return headPose;
	}

	public void setHeadPose(HeadPose headPose) {
		this.headPose = headPose;
	}

	public Map<String, Float> getEmotion() {
		return emotion;
	}

	public void setEmotion(Map<String, Float> emotion) {
		this.emotion = emotion;
	}

	public Hair getHair() {
		return hair;
	}

	public void setHair(Hair hair) {
		this.hair = hair;
	}

	public Makeup getMakeup() {
		return makeup;
	}

	public void setMakeup(Makeup makeup) {
		this.makeup = makeup;
	}

	public Occlusion getOcclusion() {
		return occlusion;
	}

	public void setOcclusion(Occlusion occlusion) {
		this.occlusion = occlusion;
	}

	public List<Accessory> getAccessories() {
		return accessories;
	}

	public void setAccessories(List<Accessory> accessories) {
		this.accessories = accessories;
	}

	public Blur getBlur() {
		return blur;
	}

	public void setBlur(Blur blur) {
		this.blur = blur;
	}

	public Exposure getExposure() {
		return exposure;
	}

	public void setExposure(Exposure exposure) {
		this.exposure = exposure;
	}

	public Noise getNoise() {
		return noise;
	}

	public void setNoise(Noise noise) {
		this.noise = noise;
	}

	@Override
	public String toString() {
		return "Attributes {age=" + age + ", gender=" + gender + ", smile=" + smile + ", glasses=" + glasses
				+ ", facialHair=" + facialHair + ", headPose=" + headPose + ", emotion=" + emotion + ", hair=" + hair
				+ ", makeup=" + makeup + ", occlusion=" + occlusion + ", accessories=" + accessories + ", blur=" + blur
				+ ", exposure=" + exposure + ", noise=" + noise + "}";
	}

}
