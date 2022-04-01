# Cullect
🎨 나만의 문화 컬렉션 - 공연 / 전시 정보 제공 어플리케이션 🎵

# 🔎 미리보기

## 메인화면 - 공연/전시 리스트 출력

<img src = "https://user-images.githubusercontent.com/57751515/160938720-6578d0dc-504a-4b1d-868b-4b234d6ccee0.png" width="250"/> <img src = "https://user-images.githubusercontent.com/57751515/160938855-bca3e42c-b1ea-4473-959a-1b1a653cec65.png" width="250"/> 
- 오늘 날짜를 기준으로 관람 가능한 공연/전시 리스트 출력
- Paging3를 활용해 데이터를 페이지로 나누어 가져옴
  - 목록 끝에 도달하면 다음 페이지의 아이템 출력
- 그리드 형식의 리사이클러뷰 내 아이템을 클릭하면 해당 공연/전시의 상세 정보 확인 가능
- StateFlow를 사용해 Ui 상태를 관리

## 분야별 공연/전시

<img src = "https://user-images.githubusercontent.com/57751515/160939927-40ea80f9-3225-4dec-9a6f-7d893d7d3e56.png" width="250"/> <img src = "https://user-images.githubusercontent.com/57751515/160939981-331fbce2-52bf-4f9d-b620-641c8531af67.png" width="250"/> <img src = "https://user-images.githubusercontent.com/57751515/160939988-65e84bf7-c697-412e-ba1e-8bb22b8fb197.png" width="250"/> <img src = "https://user-images.githubusercontent.com/57751515/160940310-c1978279-830c-40a2-b29c-01d5c5cca9be.png" width="250"/>

- 연극, 음악, 무용 등 분야별 공연/전시 리스트 확인 가능
- 선택 분야의 공연/전시가 없을 시 결과가 없다는 문구 출력

## 공연/전시 상세 정보

 <img src = "https://user-images.githubusercontent.com/57751515/160940594-bba75101-e05f-4610-b06d-2fe278319f1f.png" width="250"/> <img src = "https://user-images.githubusercontent.com/57751515/160940575-0c34a207-d333-41fa-817d-173c5279f5f1.png" width="250"/> <img src = "https://user-images.githubusercontent.com/57751515/160940611-c0f0c34b-3a41-426e-ac26-487ef95dd238.png" width="250"/> 
 
- 테마, 위치, 오픈 기간, 좌석 가격 등의 상세 정보 출력
- 예매하러가기 버튼을 통해 해당 전시/공연의 예매 또는 상세 정보 사이트로 이동
- NaverMap을 활용해 위치를 마커로 지도에 표시

## Ui 상태에 따른 관리
![ezgif-1-7b5b6e4920](https://user-images.githubusercontent.com/57751515/160946056-b6c900ed-ace8-4b1e-aebc-f02e053b758a.gif)
- StateFlow를 통해 UiState를 관리
  - 로딩 시 쉬머 Lottie 애니메이션 출력
  - 에러 시 에러 내용 출력
  - 성공 시 수집한 데이터 출력

## +) 전시 찜 기능은 구현 중.. 🏃🏻‍♀️

## 🔧 App Version

targetSdkVersion 30 / minSdkVersion 21 

# 🛶 Tech Stack

## 🏛️ Architecture

- MVVM

## 📚 Libraries

- Android Jetpack
  - [Navigation](https://developer.android.com/jetpack/androidx/releases/navigation)
  - [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel)
  - [Lifecycle](https://developer.android.com/jetpack/androidx/releases/lifecycle)
  - [DataBinding](https://developer.android.com/topic/libraries/data-binding)
  - [Paging3](https://developer.android.com/topic/libraries/architecture/paging/v3-overview)
- [Retrofit2](https://square.github.io/retrofit/)
- [OkHttp](https://github.com/square/okhttp)
- [Coroutines](https://kotlinlang.org/docs/coroutines-overview.html) 
- [Glide](https://github.com/bumptech/glide) 
- [Hilt](https://developer.android.com/training/dependency-injection/hilt-jetpack) 
- [Timber](https://github.com/JakeWharton/timber)
- [Naver Map SDK](https://www.ncloud.com/product/applicationService/maps)
