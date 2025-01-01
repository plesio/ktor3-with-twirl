# ktor3-with-twirl

�x�[�X�� [Ktor Project Generator](https://start.ktor.io) �ō쐬���āA�����Ɏ���������B

## �\���ɂ���

* �r���h�V�X�e��
  * Gradle + build.gradle.kts
* �t���[�����[�N
  * ktor 3.x
* HTML�e���v���[�g
  * Twirl
    * ���� Play Framework �̕W��Template Engine�B
    * Scala���Ȃ̂ƁAPlay�ȊO�ł܂Ƃ��ȘA�g�v���O�C����񋟂��Ă����͂Ȃ����߁A�C���̓��B
    * ������� ktor �Ƃ��ȒP�ɂ͘A�g�ł��Ȃ��B
* Java/JDK
  * 11 / 17

## Building & Running

### �r���h����ꍇ

| Task                                      | Description                                                                         |
|-------------------------------------------|-------------------------------------------------------------------------------------|
| `./gradlew compileScala -x compileKotlin` | Scala, Twirl �� Kotlin ������s�r���h���Ȃ��Ƃ����Ȃ��� compileKotlin���ˑ��ɂ��邽�߁A���̃R�}���h�Ŗ������r���h��ʉ߂�����B |
| `./gradlew war`                           | ��� ������ compileScala ��ʂ�������Ȃ� compileKotlin ���ʂ邽�߁A����Ńr���h�ł���B                         |

### Run����ꍇ

| Task                                      | Description                                                 |
|-------------------------------------------|-------------------------------------------------------------|
| `./gradlew compileScala -x compileKotlin` | _                                                           |
| `./gradlew runAppWar`                     | ��� ������ compileScala ��ʂ�������Ȃ� compileKotlin ���ʂ邽�߁A����Ńr���h�ł���B |

If the server starts successfully, you'll see the following output:

```
2024-12-04 14:32:45.584 [main] INFO  Application - Application started in 0.303 seconds.
2024-12-04 14:32:45.682 [main] INFO  Application - Responding at http://0.0.0.0:8080
```

## ��������

�߂�����r���h�Ɏ��Ԃ������邩���B

* �o�b�e���[�쓮�m�[�gPC + WSL2 + Win�̈�̃f�[�^�̈�� build �� 4��������ƁB
  * �iWS2�{Win�̈悾���炩���H�j
* ���l�ɁA�o�b�e���[�쓮��Ԃ̃m�[�gPC + CMD + Java11 �� build �� 51�b�B
  * �f�B�X�NI/O���x���������Ă�1���߂��͂������Ă��܂������B
