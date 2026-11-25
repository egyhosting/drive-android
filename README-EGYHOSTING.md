# EgyHosting Drive for Android

Branded build of the [Nextcloud Android client](https://github.com/nextcloud/android) for
[EgyHosting Drive](https://egyhosting.com/drive.php). Licensed under the same terms as upstream
(AGPL-3.0-or-later OR GPL-2.0-only). This repository is the public source of the app.

Upstream base: `stable-35.0.2`.

## What is changed
Everything EgyHosting-specific is in one place, so upstream updates merge cleanly:

| Path | What |
|---|---|
| `app/build.gradle.kts` | flavor `egyhosting` (`com.egyhosting.drive`), Java from `src/generic`, optional release signing from env vars |
| `app/src/egyhosting/res/values/setup.xml` | app name, provider ids, fixed server login, colours, links |
| `app/src/egyhosting/res/values*/egd_strings.xml` | upstream strings that hardcode "Nextcloud" |
| `app/src/egyhosting/res/mipmap-*`, `drawable*` | launcher icon, splash and logos (replace the Nextcloud trademark artwork) |
| `.github/workflows/egyhosting-build.yml` | CI build; upstream workflows parked in `.github/upstream-workflows-disabled` |

Login always goes to `https://drive.egyhosting.com` (browser login flow, no server address field).
Push notifications are not enabled yet (the generic flavor has no Firebase).

## Build
CI builds on every push to `main`: debug APK (for test phones) and, when the signing secrets
are set, a signed release AAB for Google Play. Locally:

```bash
./gradlew assembleEgyhostingDebug
```

## Updating to a new upstream release
```bash
git remote add upstream https://github.com/nextcloud/android.git   # once
git fetch upstream tag stable-X.Y.Z --no-tags
# replace the tree with upstream, then re-apply the EgyHosting commit
```
Icons are generated from the company logo by `make_android_icons.py` in the EgyHosting Drive project.
