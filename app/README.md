# Onboarding Animation

## Overview
This project implements the onboarding animation screen as per the Figma design ("Dev_Assignment Onboarding animation.fig").  
It uses **Jetpack Compose**, **MVVM**, **Retrofit**, and **Coroutines** to create smooth card animations and transitions.

API used: [Education Metadata](https://myjar.app/_assets/shared/education-metadata.json)

---

## Features
- Animated onboarding cards with tilt, expand/collapse, and bottom-to-top entrance.
- Smooth background gradient transitions per card.
- Floating CTA button with Lottie animation.
- Responsive layout with modern Android development best practices.

---

## Tech Stack
- Kotlin, Jetpack Compose, MVVM
- Retrofit + Coroutines for network
- Lottie for animations
- Dagger / Hilt for dependency injection (if applicable)

---

## Setup
1. Clone the repo:
   ```bash
   git clone <your-repo-url>
2. Open in Android Studio (Arctic Fox or later).

3. Sync Gradle and run on an emulator or device.

## Notes

1. Tested on Android 11+.
2. Internet required for API and Lottie animations.