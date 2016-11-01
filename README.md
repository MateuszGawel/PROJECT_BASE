# PROJECT_BASE
Project for apptogo games as an initial pack of sources

# INSTRUCTIONS
- clone PROJECT_NAME repository
- use libgdx jar to generate gradle project
- use github windows gui and create repository (you won't be able to create new repo ontop of gradle project for some reason so you have to use another path)
- copy everything from generated libgdx gradle project into your repository which should only have git-related files.
- copy everything (except .git directory) from PROJECT_BASE repository to your new repository and merge all dirs and files
- open eclipse -> import -> gradle project -> build model -> import
- in core/android/desktop subprojects remove generated package
- rename com.apptogo.PROJECT_NAME to desired name. Remember to check checkbox "rename subpackages"
- you can build and run project. If android doesn't work open properties and check proper android sdk.
- remember to commit changes of your new game and push repository to github (I used github gui for that)

