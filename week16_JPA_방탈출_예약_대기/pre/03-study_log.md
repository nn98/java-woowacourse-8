# 학습 로그

<h2 id="user-content-미션1-repository-코드-다시-읽기"><a tabindex="-1" href="#미션1-repository-코드-다시-읽기"></a>미션1 Repository 코드 다시
읽기</h2>

<p>본격 시작 전에 <strong>본인의 미션1 4단계 코드</strong>를 한 번 다시 읽고 다음 메모를 남깁니다.</p>
<ul>
<li><code>JdbcTemplate</code>이 직접 다루는 SQL은 몇 종류인가? (insert/select/update/delete/join)</li>

- 싹다

<li>도메인 객체와 테이블의 관계가 1 : 1인가?</li>  

- 굳이 대응하지 않아도 되지만, 굳이 대응을 파괴할 필요는 없으니 현재 1:1

<li>연관 데이터를 가져올 때 join을 SQL에 박아두었나, 두 번 조회했나?</li> 

- SQL 에서 처리. 도메인 로직으로 표현하는 것이 `이론적으로` 바람직하다 생각했으나  
  쿼리 단에서 처리하도록 책임을 이관하는 것이 `실용적으로` 바람직하다 생각했고 후자를 채택

<li>만약 이걸 객체 그래프(<code>reservation.getTime().getStartAt()</code>)로 표현한다면 어느 코드가 사라질까?</li>

- 현재로선 답할 수 없다. 몰라서

</ul>
<blockquote>
<p>이 메모가 <strong>0단계·1단계의 시작점</strong>이 됩니다. 학습 로그 첫 줄로 남기면 좋습니다.</p>
</blockquote>

