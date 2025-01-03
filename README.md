# ktor3-with-twirl

ベースは [Ktor Project Generator](https://start.ktor.io) で作成して、そこに手を加えた。

## 構成について

- ビルドシステム
  - Gradle + build.gradle.kts
- フレームワーク
  - ktor 3.x
- HTML テンプレート
  - Twirl
    - 所謂 Play Framework の標準 Template Engine。
    - Scala 製なのと、Play 以外でまともな連携プラグインを提供している例はないため、修羅の道。
    - もちろん ktor とも簡単には連携できない。
- Java/JDK
  - 11 / 17

## 検証環境

- Windows 11 + Java 11
- Ubuntu 24.10 + Java 17

## Building & Running

### ビルドする場合

| Task                                      | Description                                                                                                                          |
| ----------------------------------------- | ------------------------------------------------------------------------------------------------------------------------------------ |
| `./gradlew compileScala -x compileKotlin` | Scala, Twirl は Kotlin よりも先行ビルドしないといけないが compileKotlin が依存にいるため、このコマンドで無理やりビルドを通過させる。 |
| `./gradlew war`                           | 先に 調整版 compileScala を通した直後なら compileKotlin が通るため、これでビルドできる。                                             |

### Run する場合

| Task                                      | Description                                                   |
| ----------------------------------------- | ------------------------------------------------------------- |
| `./gradlew compileScala -x compileKotlin` | \_                                                            |
| `./gradlew war`                           | \_                                                            |
| `./gradlew appRunWar`                     | 正しくビルドできていたらこれで War を使って起動テストできる。 |

If the server starts successfully, you'll see the following output:

```
2024-12-04 14:32:45.584 [main] INFO  Application - Application started in 0.303 seconds.
2024-12-04 14:32:45.682 [main] INFO  Application - Responding at http://0.0.0.0:8080
```

## 制限事項

めっちゃビルドに時間がかかるかも。

- バッテリー駆動ノート PC + WSL2 + Win 領域のデータ領域で build が 4 分ちょっと。
  - （WS2 ＋ Win 領域だからかも？）
- 同様に、バッテリー駆動状態のノート PC + CMD + Java11 で build で 51 秒。
  - ディスク I/O 速度を解決しても 1 分近くはかかってしまいそう。
