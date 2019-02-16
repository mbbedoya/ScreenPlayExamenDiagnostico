
@CreditoHipotecarioLibreInversion
Feature: Fomr of Libre inversion
  As an AVillas user I want to verify 
  if I have capacity to get a credit
  of free investment

  Background: Get until form page
    Given I am in the form page

  @SentTheFormWithoutInformation
  Scenario: Form without information
    When I click the form buttom to send it
    Then I hopo to see the massege "Debes seleccionar un documento" 
    And the message "Debes escribir" below to the field 


  @SentTheFormWithEmailAndCellPhoneWrong
  Scenario Outline: Form with wrong information
    When I type the information  <FirtsName> <CellNumber> <Email> 
    And I click the form buttom to send it
    Then I hopo to see the massege <messageForEmail> for the email field
    And the message <messageForCellPhone> for the cell phone field
    
     Examples:
							|FirtsName|CellNumber|Email |messageForEmail|messageForCellPhone|
							|"Nombre" |"32187"   |"sdad"|"Ingrese una"  |"celular no es"    |
	
	
	@SentTheFormWithGoodInformation
  Scenario Template: Form with good information
    When I type the information completed for the <numberOfTheUser>
    And  I click the form buttom to send it
    Then I hopo to see the massege "INSCRIPCIÓN AL PROGRAMA PUNTOS POR TODO" in the next page
    
    Examples:
    
    |numberOfTheUser|
    |0              |
