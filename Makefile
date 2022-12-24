JAVAC = javac
FILE = scenario.txt

all :
	@$(MAKE) compile

compile :
	find * -name "*.java" > sources.txt
	javac @sources.txt

clean :
	find * -name "*.class" -delete

run :
	java kr.ft.avaj.simulator.Simulator $(FILE)

re :
	@$(MAKE) clean
	@$(MAKE) all