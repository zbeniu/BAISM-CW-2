# BAISM-CW-2

Prosta aplikacja Android (Kotlin) z logiką `PasswordValidator` i testami jednostkowymi.
Repozytorium służy jako źródło kodu dla pipeline'u CI/CD na Bitrise (workflow `safe_build`):

1. git clone
2. testy jednostkowe (`./gradlew testDebugUnitTest`) – pipeline pada, gdy test nie przejdzie
3. `mobsfscan --type android app/src` – pipeline pada przy findingach `ERROR`
4. build APK (`assembleDebug`)
5. deploy artefaktu do bitrise.io

Trigger: Pull Request do brancha `main` -> workflow `safe_build` (patrz `bitrise.yml`).
