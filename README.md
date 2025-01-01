# ktor3-with-twirl

ベースは [Ktor Project Generator](https://start.ktor.io) で作成して、そこに手を加えた。

## 構成について

* ビルドシステム
  * Gradle + build.gradle.kts
* フレームワーク
  * ktor 3.x
* HTMLテンプレート
  * Twirl
    * 所謂 Play Framework の標準Template Engine。
    * Scala製なのと、Play以外でまともな連携プラグインを提供している例はないため、修羅の道。
    * もちろん ktor とも簡単には連携できない。
* Java/JDK
  * 11 / 17

## Building & Running

### ビルドする場合

| Task                                      | Description                                                                         |
|-------------------------------------------|-------------------------------------------------------------------------------------|
| `./gradlew compileScala -x compileKotlin` | Scala, Twirl は Kotlin よりも先行ビルドしないといけないが compileKotlinが依存にいるため、このコマンドで無理やりビルドを通過させる。 |
| `./gradlew war`                           | 先に 調整版 compileScala を通した直後なら compileKotlin が通るため、これでビルドできる。                         |

### Runする場合

| Task                                      | Description                                                 |
|-------------------------------------------|-------------------------------------------------------------|
| `./gradlew compileScala -x compileKotlin` | _                                                           |
| `./gradlew runAppWar`                     | 先に 調整版 compileScala を通した直後なら compileKotlin が通るため、これでビルドできる。 |

If the server starts successfully, you'll see the following output:

```
2024-12-04 14:32:45.584 [main] INFO  Application - Application started in 0.303 seconds.
2024-12-04 14:32:45.682 [main] INFO  Application - Responding at http://0.0.0.0:8080
```

## 制限事項

めっちゃビルドに時間がかかるかも。

* バッテリー駆動ノートPC + WSL2 + Win領域のデータ領域で build が 4分ちょっと。
  * （WS2＋Win領域だからかも？）
* 同様に、バッテリー駆動状態のノートPC + CMD + Java11 で build で 51秒。
  * ディスクI/O速度を解決しても1分近くはかかってしまいそう。
