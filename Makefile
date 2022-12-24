JAVAC = javac
FILE = ./example/senario.txt

all :
	@$(MAKE) compile
	@$(MAKE) run

compile :
	find * -name "*.java" > sources.txt
	javac @sources.txt

clean :
	find * -name "*.class" -delete

run :
	java kr.ft.avaj.simulator.Simulator $(FILE)

re :
	@$(MAKE) clean
	@$(MAKE) alls