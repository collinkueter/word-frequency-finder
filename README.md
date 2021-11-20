# Word Frequency Finder

Given an url to a text file, this application finds the top n words based on their frequency, excluding common words such as "a", "the", etc.

## How to Deploy to Google Cloud Platform (GCP)

1. Substitute your Google Cloud Project ID in the `packageName` field in the `build.sbt` file
2. Authenticate with the Google Cloud SDK
3. Run `sbt docker:publish` to publish your image to Container Registry
4. Run `gcloud run deploy word-frequency-finder --image us.gcr.io/your-project-id/word-frequency-finder:latest` (substituting your project id) to deploy your application to Google Cloud Run