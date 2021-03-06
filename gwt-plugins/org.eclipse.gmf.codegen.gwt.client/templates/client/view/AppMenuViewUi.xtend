package client.view

import org.eclipse.gmf.codegen.gmfgen.GenEditorGenerator

class AppMenuViewUi extends Ui {

	override filePath(GenEditorGenerator it) { 
		super.filePath(it) + "AppMenuView.ui.xml"
	}

	override additions(GenEditorGenerator it) '''
		<ui:with field='res' type='«baseClientPackage».icons.Icons' />
	'''

	override style() '''
		.top-header {
			left: 0;
			position: fixed;
			right: 0;
			top: 0;
			z-index: 1000;
			border-bottom: 1px solid rgba(0, 0, 0, 0.05);
			box-shadow: 0px 0.0625em 0.3125em rgba(0, 0, 0, 0.15);
		}
		.header {
			position: relative;
			height: 40px;
			border-bottom: 1px solid rgba(0, 0, 0, 0.15);
			width: 100%;
		}
		.header-inner {
			background: none repeat scroll 0% 0% rgb(250, 250, 250);
			height: 40px;
		}
		.diagram-control {
			position: absolute;
			top: 10px;
			left: 10px;
		}
		.diagram-control-group {
			position: relative;
			display: inline-block;
			vertical-align: middle;
			margin: 0 10px;
		}
		.icon-button {
			border: 0px none;
			border-radius: 2px;
			color: white;
			cursor: pointer;
			display: inline-block;
			vertical-align: middle;
			font-size: 16px;
			margin: 0px 2px 2px;
			outline: 0px none;
			text-decoration: none;
			line-height: inherit;
			width: 24px;
			height: 24px;
		}
		.icon-button:hover {
			border: 1px solid #D3D3D3;
			background: #E5E5E5;
		}
		.icon-button:active {
			border: 1px solid #D3D3D3;
			background: #C5C5C5;
		}
		.icon-button > img {
			margin-top: 4px;
			margin-left: 4px;
		}
	'''
	
	override content() '''
		<g:HTMLPanel styleName="{style.top-header}">
			<g:HTMLPanel styleName="{style.header}">
				<g:HTMLPanel styleName="{style.header-inner}">

					<g:HTMLPanel styleName="{style.diagram-control}">

						<g:HTMLPanel styleName="{style.diagram-control-group}">
							<g:HTMLPanel ui:field="menuButton" styleName="{style.icon-button}">
								<g:Image resource='{res.file}'/>
							</g:HTMLPanel>
						</g:HTMLPanel>

						<g:HTMLPanel styleName="{style.diagram-control-group}">
							<g:HTMLPanel ui:field="paletteButton" styleName="{style.icon-button}">
								<g:Image resource='{res.palette}'/>
							</g:HTMLPanel>
							<g:HTMLPanel ui:field="propertyButton" styleName="{style.icon-button}">
								<g:Image resource='{res.properties}'/>
							</g:HTMLPanel>
						</g:HTMLPanel>

						<g:HTMLPanel styleName="{style.diagram-control-group}">
							<g:HTMLPanel ui:field="deleteButton" styleName="{style.icon-button}">
								<g:Image resource='{res.delete}'/>
							</g:HTMLPanel>
							<g:HTMLPanel ui:field="undoButton" styleName="{style.icon-button}">
								<g:Image resource='{res.undo}'/>
							</g:HTMLPanel>
							<g:HTMLPanel ui:field="redoButton" styleName="{style.icon-button}">
								<g:Image resource='{res.redo}'/>
							</g:HTMLPanel>
						</g:HTMLPanel>

						<g:HTMLPanel styleName="{style.diagram-control-group}">
							<g:HTMLPanel ui:field="zoomInButton" styleName="{style.icon-button}">
								<g:Image resource='{res.zoomIn}'/>
							</g:HTMLPanel>
							<g:HTMLPanel ui:field="zoomOutButton" styleName="{style.icon-button}">
								<g:Image resource='{res.zoomOut}'/>
							</g:HTMLPanel>
						</g:HTMLPanel>

					</g:HTMLPanel>

				</g:HTMLPanel>
			</g:HTMLPanel>
		</g:HTMLPanel>
	'''
	
}