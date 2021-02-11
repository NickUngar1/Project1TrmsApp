Feature: Logging in to TRMS

	#gets rid of need to have given statemet in each of scenarios
	Background:
		Given guest is on login page
		
	Scenario Outline: guest enters credentials and presses login button
		When the user types in "<email>" and
		Then the employee name should be "<name>" and
		
	Examples:
		#this will ignore white space so you can format like this...
		|	email							|	name				|
		|	lanakane@agent.com				|	Lana Kane			|
		|	sterlingarcher@agent.com		|	Sterling Archer		|