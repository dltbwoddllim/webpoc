1. 같은 코드에서 갑자기 string을 object로 변형 못함.
2. null로 표시됨. - articlepage가
3. 브라우저는 자동 파싱 길이에 제한이 있음.(길이는 문제가 아닌듯 짧게 해도 같은 이슈 발생.)
4. 데이터 베이스 text가 다음과 같은 형식이면 string을 json으로 파싱 못함
    "
    text 시작".