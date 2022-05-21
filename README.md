# Sejong
한글 관련 유틸리티 클래스입니다.
## 사용 예
```kotlin
val text = "구구%s 새로 마구찌르기%s 배웠다."
val formattedText = HangulJosaFormatter.format(text, HangulJosaPair.EUN_NEUN, HangulJosaPair.EUL_REUL)

assertEquals("구구는 새로 마구찌르기를 배웠다.", formattedText)
```