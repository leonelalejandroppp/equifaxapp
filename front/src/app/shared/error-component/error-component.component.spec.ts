import { ComponentFixture, TestBed } from "@angular/core/testing";

import { ErrorComponentComponent } from "./error-component.component";

describe('LoginComponent', () => {
  beforeEach(() => {
    fixture = TestBed.createComponent(ErrorComponentComponent);
    fixture.autoDetectChanges();
  });

  let fixture: ComponentFixture<ErrorComponentComponent>;

  it("should not render div without error message", () => {
    fixture.componentInstance.errorMessage = '';
    fixture.detectChanges();

    const divElement = fixture.debugElement.nativeElement.querySelector('#errorMessage');
    expect(divElement).toBeFalsy();
  });

  it("should render div with error message", () => {
    fixture.componentInstance.errorMessage = 'Error';
    fixture.detectChanges();

    const divElement = fixture.debugElement.nativeElement.querySelector('#errorMessage');
    expect(divElement).toBeTruthy();
  });

  it("should render error message with text", () => {
    fixture.componentInstance.errorMessage = 'Mensaje de Error';
    fixture.detectChanges();

    const compiled = fixture.nativeElement;
    expect(compiled.querySelector('#errorMessage').textContent).toContain('Mensaje de Error');

  })
});