# HomeTask_3: тесты на задания "Dev Intensive 2019" от Skill Branch

<b>ВНИМАНИЕ!</b> тесты нужно засунуть в дирректорию с <b>ANDROID</b> тестами (androidTests)

<b>ВНИМАНИЕ!</b> Необходимо добавить в build.gradle зависимость в dependencies:

>  ` androidTestImplementation 'com.android.support.test:rules:1.0.2' `

и убедиться, что пакет и версия соответствую с раннером:

> ` androidTestImplementation 'com.android.support.test:runner:1.0.2' ` </br>
Полный [build.gradle здесь](https://github.com/russdreamer/dev-intensive-2019-tests/blob/hometask_3_tests/app/build.gradle)

</br></br>
* Здесь лежат тесты уже для всех заданий.
* Для вашего удобства тесты разбиты по названию в соответствии с нумерацией заданий.
* Методы, на которые составлены тесты, <b>успешно</b> прошли проверку ботом. Если проверка ещё не пройдена - тест будет в конце этого описания в списке <b>"Непроверенные методы"</b>.
* Так как функционал классов и методов от урока к уроку может отличаться, каждый этап будет в отдельной ветке.
* Ветки нумеруются согласно рабочим веткам. Т.е. hometask_3 в вашем репозитории == hometask_3_tests этого репозитория.
* Тесты можно и нужно дополнять, если хотите - можете форкаться, можете писать в телеграмме (@Igatroll), а можете просто пользоваться.
  
  
> Непроверенные методы:
* --отсутствуют--

</br></br>
Ошибки:</br>
В случае возникновения ошибок, когда не может найти классы тестов в импорте - проверьте, используете ли вы в build.gradle:</br>
`testInstrumentationRunner "androidx.test.runner.AndroidJUnitRunner"`

в этом случае помимо</br>
` androidTestImplementation 'com.android.support.test:rules:1.0.2'`

добавить в зависимости:</br>
`androidTestImplementation 'androidx.test.espresso:espresso-core:3.2.0'`</br>
`androidTestImplementation 'androidx.test:runner:1.2.0'`
