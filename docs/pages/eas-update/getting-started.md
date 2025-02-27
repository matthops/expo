---
title: Getting started
---

Setting up EAS Update allows you to push critical bug fixes and improvements that your users need right away.

EAS Update is in "preview", meaning that we may still make breaking developer-facing changes. With that, EAS Update is ready for production apps. Read through the [known issues](/eas-update/known-issues) to ensure EAS Update is ready for your project.

## Install Expo CLI and EAS CLI

1. Install EAS and Expo CLIs with:

   ```bash
   npm install --global eas-cli expo-cli
   ```

   EAS Update requires EAS CLI >= 0.40.0 and Expo CLI >= 4.13.0.

## Create an Expo account

1. Create an account at [https://expo.dev/signup](https://expo.dev/signup)
2. Then, log in with EAS CLI:

   ```bash
   eas login
   ```

3. After logging in, you can verify the logged in account with `eas whoami`.

## Create a project

1. Create a project with Expo CLI by running:

   ```bash
   expo init
   ```

2. Select "Managed workflow > blank".

## Configure your project

1. Install the latest `expo-updates` library with:

   ```bash
   expo install expo-updates
   ```

2. Initialize your project with EAS Update:

   ```bash
   eas update:configure
   ```

   After this command, you should have a new field in your app config (**app.json**) at `expo.updates.url`, which is the URL where your app will fetch new updates.
   <br/><br/>

   > There is also a `fallbackToCacheTimeout` property under `expo.updates`. If you'd like your app to attempt to load new updates when a user opens the app, set this to something other than zero, like `3000` (3 seconds). A value of `3000` would mean that your app will attempt to download a new update for up to 3 seconds before loading the previous update it already has locally. If the app is able to download the update within 3 seconds, your users will see the changes in the newest update immediately.

3. To set up the configuration file for builds, run:

   ```bash
   eas build:configure
   ```

   Then follow the prompts.

   This will create a file named **eas.json**.

4. Inside the `preview` and `production` build profiles in **eas.json**, add a `channel` property for each:

   ```bash
   {
     "build": {
        "preview": {
          ...
          "channel": "preview"
        },
        "production": {
          ...
          "channel": "production"
        },
       ...
     }
   }
   ```

   This `channel` property will allow you to point updates at builds. For example, if you set up a GitHub Action to publish changes on merge, it will make it so we can merge code into the "production" branch, then those commits will publish an update that will be made available to builds with the channel "production".

## Create a build for the project

Next, we'll need to create a build for Android or iOS. [Learn more](/build/setup). Once you have a build running on your device or in a simulator, we'll be ready to send it an update.

## Publish an update

Now we're ready to publish an update to the builds created in the previous step.

1. When we run our project locally, Expo CLI creates a manifest locally that Expo Go or a development build will run. To make sure our project starts with Expo's modern manifest protocol, start your local server with:

   ```bash
   yarn start --force-manifest-type=expo-updates
   ```

2. Then, make any desired changes to your project's JavaScript, styling, or image assets.
3. Then publish an update with the following command:

   ```bash
   eas update --branch [branch] --message [message]

   # Example
   eas update --branch production --message "Updating the app"
   ```

4. Once the update is built and uploaded to EAS and the command completes, force close and reopen your app up to two times to download and view the update.

## Next

You can publish updates continuously with GitHub Actions. Learn more: [Using GitHub Actions with EAS Update](/preview/eas-update/github-actions)
