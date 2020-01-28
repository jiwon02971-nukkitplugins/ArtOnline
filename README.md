##1. pom.xml에 등록하기
```
<repositories>
	<repository>
		<id>ArtOnline</id>
		<url>https://github.com/jiwon02971/ArtOnline/tree/master</url>
	</repository>
</repositories>

<dependencies>
	<dependency>
		<groupId>iKguana</groupId>
		<artifactId>ArtOnline</artifactId>
		<version>1.0.0</version>
	</dependency>
</dependencies>
```

## SimpleDialog 사용하기
```
SimpleDialog.sendDialog(Object clz, String name, Player player, FormWindow window, Object data);
>> clz클래스의 name(FormRespondedEvent, Object); 라는 메소드에 결과값이 전송됩니다. 
>> clz또는 name이 null일시 결과값이 전송되지 않습니다.

SimpleDialog.sendDialog(Object clz, String name, Player player, Type type, Object data); 
>> 1. Type에 SimpleDialog.Type.FILTERING 을 넣을시에는 data 값에는 반드시 ArrayList<String>이 전달되어야합니다.
>>    Object의 기본값은 온라인 플레이어들의 닉네임 목록입니다. 목록의 size가 10이 넘을경우 필터링을 사용할수있습니다.
>>    FormWindowSimple의 Response가 결과값으로 전달됩니다. 클릭된 버튼의 text로 정확한 결과를 얻을수 있습니다. 
>> 2. Type에 SimpleDialog.Type.FILTERING_SKIP 을 넣을시에는 SimpleDialog.Type.FILTERING과 거의 비슷합니다.
>>    다른점이라면 필터링을 절대로 사용하지 않는것입니다.
>> 3. Type에 SimpleDialog.Type.ONLY_TEXT 를 넣을시에는 data 값에는 String 값이 전달되어야 합니다.
>>    결과값이 전송되지 않습니다.
```

## Profiler 사용하기
```
Profiler.getInstance().isPlayerRegistered(String name); -> Boolean
>> name이라는 플레이어의 데이터 콘피그가 생성되었는지 true/false로 반환합니다.

Profiler.getInstance().getExactName(String name); -> String
>> name이라는 플레이어의 정확한 닉네임을 불러옵니다.
>> ex) iKguana 라고 등록되어있는 경우. Profiler.getInstance().getExactName("ikguana"); -> iKguana;

Profiler.getInstance().open(String player); -> Config
>> player의 Config파일을 반환합니다.
>> 저장을 직접 호출할 필요가 없습니다.
>> player에는 정확한 닉네임을 입력할것을 추천합니다.

Profiler.getInstance().getProfileList(); -> ArrayList<String>
>> 등록되어있는 플레이어들의 모든 닉네임을 불러옵니다.
```

## LogAPI 사용하기
```
LogAPI.saveLog(String dirname, String data);
>> main폴더의 logs-custom/dirname 이라는 폴더가 생성됩니다.
>> 생성된 폴더의 하위에 yyyyMMdd.txt 형식의 텍스트 파일이 생성됩니다.
>> 텍스트파일에는 kkMM data 라는 문구가 추가됩니다.
>> ex-filename) 20190128.txt
>> ex-fileinside) 15:09 Player placed block.
>> ex-fileinside) 15:10 Player destroyed block.
>> ex-fileinside) 17:20 Player used command /time set 3000.
```