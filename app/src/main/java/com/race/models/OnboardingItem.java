package com.race.models;

public class OnboardingItem {
    int onboardingImage;
    String description;

    public OnboardingItem(int onboardingImage, String description) {
        this.onboardingImage = onboardingImage;
        this.description = description;
    }

    public int getOnboardingImage() {
        return onboardingImage;
    }

    public void setOnboardingImage(int onboardingImage) {
        this.onboardingImage = onboardingImage;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
