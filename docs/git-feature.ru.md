# Группа команд git-feature
##switch
Команда для переключения проектов на фича ветки

Параметры:
		
	-f <feature branch name>

##init
Команда для выгрузки repo projects
получает manifest проект если его нет 
обновляет, если manifest проект уже есть

Параметры:

    -M <manifet git url>
        требуется задавать если нет проекта manifest
	-b <manifest branch>
		параметр задает ветку манифеста которую надо использовать

##sync
Команда для обновления repo projects
получить обновление для проектов по манифесту из центрального репозитория		

##status
Команда для получения git status по каждому компоненту
команда показывает
* неотслеживаемые файлы
* незакоммиченные изменения
* незапушенные коммиты

##grep
Команда для поиска по всем компонентам силами git grep

Параметры:
    
    -e <expression> 
        регулярное выражение для поиска


##merge-abort
Команда для удаления последствий неудачного мержа

##stash 
Команда для сохранения незакоммиченных изменений

##stash-pop 
Команда для восстановления незакоммиченных изменений

Парамеры:
	
	-f <featureBranch>

##prepare-merge
Команда для отведения prepareBuild веток и мержа в них фича веток

Парамеры:
	
	-f <featureBranch>

##feature-merge-release
Команда используется для объединения изменений из релизных веток в фича ветки
Применяется к компонентам кторые имеют фича ветки
Перед применением команды необходимо выполнить команды sync switch

Парамеры:

    -f <featureBranch>

##push-feature
Комадна используется для того чтобы отправить на сервер изменения на featureBranch
если в компоненте есть локальная ветка featureBranch

Парамеры:

    -f <featureBranch>
    
    
##push-manifest
Комадна используется для того чтобы отправить на сервер изменения на manifestBranch
manifestBranch получается из манифеста проекта
    