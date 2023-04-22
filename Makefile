JAVAC = javac
FILE = ./example/scenario.txt

all :
	@$(MAKE) compile
	@$(MAKE) run

compile :
	find * -name "*.java" > sources.txt
	javac @sources.txt

clean :
	find * -name "*.class" -delete

run :
	java kr.ft.avaj.simulator.main $(FILE)

re :
	@$(MAKE) clean
	@$(MAKE) all