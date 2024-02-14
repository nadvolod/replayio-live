# Selenium (Java) & Replay.io example

Replay.io is a time-travelling DevTool that enables you to examine, debug and fix your tests. It provides a unique insight into your app code, so you can get an understanding of what happens to your application while under test. This enables you to fix flaky or failing test and make sure that intention of your test and the result is met.

Replay has two main parts:
1. Replay Browser
2. Replay DevTools

Replay Browser is a Chromium based browser that automatically records all browser activity. It captures the communication between browser and operation system, which means it goes deeper than any other test reporter. These recordings made by Replay Browser are called "replays" - because you can replay your whole test activity.

Replay DevTools are web-based DevTools that enable you to examine your replays. You can view interactions, network activity, DOM elements, React components and you can debug your application using print statements and debugger.

You can find out more in [Replay documentation](https://docs.replay.io?utm_source=github)

## What’s in this repo
Since Replay Browser is a Chromium based browser, you can create a replay using your test script. In this repo, you’ll find ane example of how to integrate Replay browser into a Java-based Selenium script.

The simple setup goes as follows:
1. Set up your test script to use Chrome webdriver
2. Install Replay browser to your system, ideally using `npm i @replayio/replay -g`
3. Set a custom path to browser binary and point that to the Replay Browser
4. Run your test 

Every time you run your test a recording of your test will be stored locally. You should be able to see a list of your recordings by typing `replay ls` command into your terminal.

Recordings should be automatically but if they don’t you can add `RECORD_ALL_CONTENT=1` variable to your environment.

## Replay DevTools
Once you have your replays created, you can upload them using `replay upload-all` command, or using `replay upload <id>` command to upload a particular replay.

To upload your you will need an API key. Go to [https://app.replay.io](https://app.replay.io?utm_source=github) and sign up. Click on "View settings" in the bottom left corner and generate your API key in the "API Keys" section. Add this key to your environment as `RECORD_REPLAY_API_KEY`

Once uploaded, terminal will output a link to your replay, which you can open in any browser. You can now examine your whole test. Learn more about Replay DevTools on [https://docs.replay.io/](https://docs.replay.io/?utm_source=github).

## Example replay
You can view the example [replay from the livestream here](https://app.replay.io/recording/replay-of-wwwsaucedemocom--12972ca8-aa4f-494d-a297-f3551d6a9f08).

