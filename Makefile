JAVAC = javac
INPUT_SCENARIO_FILENAME = scenario.txt
INPUT_SCENARIO_DIR = ./resources/scenario/
INPUT_SCENARIO = $(INPUT_SCENARIO_DIR)$(INPUT_SCENARIO_FILENAME)

all :
	@$(MAKE) compile
	@$(MAKE) run

compile :
	find * -name "*.java" > sources.txt
	javac @sources.txt

clean :
	find * -name "*.class" -delete
	rm -f sources.txt
	rm -f simulation.txt

run :
	java kr.ft.avaj.simulator.main $(INPUT_SCENARIO)

re :
	@$(MAKE) clean
	@$(MAKE) all